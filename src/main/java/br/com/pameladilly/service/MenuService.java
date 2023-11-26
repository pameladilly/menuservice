package br.com.pameladilly.service;

import br.com.pameladilly.DTO.MenuDTOResponse;
import br.com.pameladilly.IMenu;
import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.keys.ReactiveKeyCommands;
import io.quarkus.redis.datasource.value.ValueCommands;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

@ApplicationScoped
public class MenuService {

    private ReactiveKeyCommands<String> keyCommands;

    private ValueCommands<String, MenuDTOResponse> countCommands;

    @Inject
    Logger log;


    @Inject
    @RestClient
    IMenu service;

    @ConfigProperty( name = "redis.expires")
    Long REDIS_EXPIRES;


    public MenuService(RedisDataSource ds, ReactiveRedisDataSource reactive) {

        countCommands = ds.value(MenuDTOResponse.class);
        keyCommands = reactive.key();

    }

    //@CacheName("my-cache")
    private MenuDTOResponse get(String key) {
        MenuDTOResponse value = countCommands.get(key);
        if (value == null) {
            return null;
        }
        return value;
    }

  //  @CacheInvalidate(cacheName = "my-cache" )
    private void set(String key, MenuDTOResponse value) {
        log.log( Logger.Level.INFO, "Salvando menu em cache: " + value.toString());
        countCommands.setex(key, REDIS_EXPIRES, value);

    }

    public MenuDTOResponse getMenu(String idMenu){
        MenuDTOResponse menu = null;
        menu = get(idMenu);

        if (menu != null) {
            log.log( Logger.Level.INFO, "Buscando menu em cache: idMenu=" + idMenu);
            return menu;
        }else{
            log.log( Logger.Level.INFO, "CACHE EXPIRADO!");
            log.log( Logger.Level.INFO, "Buscando menu em menuservicebackoffice:getMenu=" + idMenu);
            menu = service.getMenu(idMenu);
            set(idMenu, menu );
        }
            return menu ;
    }
}
