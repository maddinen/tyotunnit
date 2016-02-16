package fi.softala.batch;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fi.softala.bean.Tunti;
import fi.softala.dao.TuntiDAO;

public class TuntiHandler {

	public static void main(String[] args) throws InvalidInputException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("TuntiHandler.main()");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		TuntiDAO dao = (TuntiDAO) context.getBean("daoLuokka");

		System.out.println("******************************************");
		System.out.println("** TERVETULOA TUNTIKIRJANPITO-OHJELMAAN **");
		System.out.println("******************************************");
		int arvo = 10;
		while (arvo != 0) {
			System.out.println("-------------------");
			System.out.println("1) Kirjaa tuntisi");
			System.out.println("2) Tarkastele kaikkia tunteja");
			System.out.println("3) Tarkastele tietyn k‰ytt‰j‰n tunteja");
			System.out.println("0) Lopeta");
			System.out.println("Tee valinta: ");
			arvo = scanner.nextInt();
			
			switch (arvo) {
			case 1:
				System.out.println("-------------------");
				System.out.println("LISƒƒ TUNTI");
				System.out.println("-------------------");
				// KAYTTAJA_ID
				System.out.println("K‰ytt‰j‰ID (makl=1, kavi=2, other=3):");
				int kayttaja_id = scanner.nextInt();
				scanner.nextLine();
				// PAIVAMAARA
				System.out.println("P‰iv‰m‰‰r‰ (yyyy-mm-dd):");
				String pvmStr = scanner.nextLine();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date pvm = null;
				try {
					pvm = format.parse(pvmStr);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// TUNTIMAARA
				System.out.println("Tuntim‰‰r‰:");
				double tunti_maara = scanner.nextDouble();
				scanner.nextLine();
				// SELITE
				System.out.println("Selite:");
				String selite = scanner.nextLine();

				Tunti tunti = new Tunti(kayttaja_id, pvm, tunti_maara, selite);
				dao.lisaaTunti(tunti);

				break;
			case 2:
				System.out.println("-------------------");
				System.out.println("LISTATAAN KAIKKI");
				System.out.println("-------------------");

				List<Tunti> tunnit = dao.haeTunnit();
				for (Tunti h : tunnit) {
				}
				break;

			case 3:
				System.out.println("Anna k‰ytt‰j‰ID (1-3):");
				int no = scanner.nextInt();
				scanner.nextLine();

				List<Tunti> kayttajanTunnit = dao.haeKayttajanTunnit(no);
				for (Tunti h : kayttajanTunnit) {
				}
				break;

			default:
				break;
			}

		}
	}

}
