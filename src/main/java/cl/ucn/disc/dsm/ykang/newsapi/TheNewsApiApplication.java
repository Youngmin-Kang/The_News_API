package cl.ucn.disc.dsm.ykang.newsapi;

import cl.ucn.disc.dsm.ykang.newsapi.model.News;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

/**
 * The News API Application.
 *
 * @author Youngmin Kang
 */
@SpringBootApplication
public class TheNewsApiApplication {

	/**
	 * The {@link NewsRepository} used to initilize the database.
	 */
	@Autowired
	private NewsRepository newsRepository;

	/**
	 * The Main starting point.
	 *
	 * @param args to use
	 */
	public static void main(String[] args) {

		SpringApplication.run(TheNewsApiApplication.class, args);
	}

	/**
	 * Initialize the data inside the Database.
	 *
	 * @return the data to use.
	 */
	@Bean
	protected InitializingBean initializingDatabase(){
		return ()->{
			final News news = new News(
					"Autoridades UCN informan a las unidades los detalles del Plan Retorno y piden acelerar regreso",
					"Noticias UCN",
					"UCN",
					"https://www.noticias.ucn.cl/destacado/autoridades-ucn-informan-a-las-unidades-los-detalles-del-plan-retorno-y-piden-acelerar-regreso/",
					"https://www.noticias.ucn.cl/wp-content/uploads/2021/11/WhatsApp-Image-2021-11-05-at-13.26.53-1.jpeg",
					"En reuniones presenciales realizadas en la Casa Central se expusieron las medidas adoptadas y se respondieron las dudas de los y las representantes de las distintas unidades de la Universidad.",
					"Directores/as y representantes de las distintas unidades académicas de Antofagasta de la Universidad Católica del Norte (UCN), recibieron con aprobación los detalles del Plan Retorno que desarrolla nuestra Casa de Estudios. En dos reuniones presenciales realizadas en el auditorio Andrés Sabella de la Casa Central, el vicerrector académico, Nelson Fernández Vergara; la vicerrectora de Asuntos Económicos y Administrativos, Ingrid Álvarez Arzic; y la directora de la Dirección de Personas (ex Dirección de Recursos Humanos) Alejandra Pizarro Véliz, les explicaron los detalles del proceso, respondiendo también las dudas de los y las asistentes.",
					ZonedDateTime.now(ZoneId.of("-4"))
			);
			// Save the news
			this.newsRepository.save(news);

		};

	}

}
