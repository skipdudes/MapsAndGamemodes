package lab.architektury;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${lab4.map.url}") String mapUrl,
			@Value("${lab4.gamemode.url}") String gameModeUrl,
			@Value("${lab4.gateway.host}") String host
	) {
		return builder
				.routes()
				.route("gamemodes", route -> route
						.host(host)
						.and()
						.path(
								"/api/gamemodes/{uuid}",
								"/api/gamemodes"
						)
						.uri(gameModeUrl)
				)
				.route("maps", route -> route
						.host(host)
						.and()
						.path(
								"/api/maps",
								"/api/maps/**",
								"/api/gamemodes/{uuid}/maps",
								"/api/gamemodes/{uuid}/maps/**"
						)
						.uri(mapUrl)
				)
				.build();
	}
}
