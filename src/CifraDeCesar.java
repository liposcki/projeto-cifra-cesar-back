import java.text.Normalizer; //ajuste de formatação do texto
import java.util.Scanner; //utilizado para capturar o texto no console do sistema.

/**
 * @author Clovis E Liposcki
 * @version 1.0
 */

public class CifraDeCesar {

static int selecaoModoDeFuncionamento;
static int chaveParaCriptografar;
static String textoParaCriptografar;

	public static void main(String[] args) {
			
		Scanner scannerString = new Scanner(System.in);
		Scanner scannerInt = new Scanner(System.in);
	
		System.out.println("Selecione uma das opções digitando o número de referência: \n1 - Para Criptografar \n2 - Para Descriptografar");		
		selecaoModoDeFuncionamento = scannerInt.nextInt();
		
		switch (selecaoModoDeFuncionamento){
		case 1:
			
			System.out.println("Digite o texto a ser criptografado: ");
			textoParaCriptografar = scannerString.nextLine().toUpperCase();
			textoParaCriptografar = Normalizer.normalize(textoParaCriptografar, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			
			System.out.println("Digite o número da chave de criptografia: ");
			
			while(scannerInt.hasNext()) {
				
				if (scannerInt.hasNextInt()) {
					chaveParaCriptografar = scannerInt.nextInt();
					break;
				} else {
					System.out.println("Digite um número inteiro!");
					scannerInt.next();
				}
			}

			
			while (chaveParaCriptografar >= 26) {
				chaveParaCriptografar = chaveParaCriptografar - 26;
			}
			
			while (chaveParaCriptografar < 0) {
				chaveParaCriptografar = chaveParaCriptografar + 26;
			}
			
			System.out.println("Texto criptografado: ");
			
			for (int i=0; i<textoParaCriptografar.length(); i++) {
				
				if (textoParaCriptografar.charAt(i) >= 65 && textoParaCriptografar.charAt(i) <= 90) {
					if (textoParaCriptografar.charAt(i) + chaveParaCriptografar > 90) {
						int textoCriptografado = (char)textoParaCriptografar.charAt(i) + chaveParaCriptografar - 26;
						char texto = (char) textoCriptografado;
						System.out.print(texto);
					} else {
						int textoCriptografado = (char)textoParaCriptografar.charAt(i)  + chaveParaCriptografar;
						char texto = (char) textoCriptografado;
						System.out.print(texto);
					}
				} else {
						int textoCriptografado = (char)textoParaCriptografar.charAt(i);
						char texto = (char) textoCriptografado;
						System.out.print(texto); 
					}
				}
			
			scannerString.close();
			scannerInt.close();
			break;
		
		case 2:
			
			System.out.println("Digite o texto a ser descriptografado: ");
			textoParaCriptografar = scannerString.nextLine().toUpperCase();
			textoParaCriptografar = Normalizer.normalize(textoParaCriptografar, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			System.out.println("Digite o número da chave de descriptografia: ");
			
			while(scannerInt.hasNext()) {
				
				if (scannerInt.hasNextInt()) {
					chaveParaCriptografar = scannerInt.nextInt();
					break;
				} else {
					System.out.println("Digite um número inteiro!");
					scannerInt.next();
				}
			}

			
			while (chaveParaCriptografar >= 26) {
				chaveParaCriptografar = chaveParaCriptografar - 26;
			}
			
			while (chaveParaCriptografar < 0) {
				chaveParaCriptografar = chaveParaCriptografar + 26;
			}
			
			System.out.println("Texto descriptografado: ");
			
			for (int i=0; i<textoParaCriptografar.length(); i++) {
				
				if (textoParaCriptografar.charAt(i) >= 65 && textoParaCriptografar.charAt(i) <= 90) {
					if (textoParaCriptografar.charAt(i) - chaveParaCriptografar < 65) {
						int textoCriptografado = (char)textoParaCriptografar.charAt(i) - chaveParaCriptografar + 26;
						char texto = (char) textoCriptografado;
						System.out.print(texto);
					} else {
						int textoCriptografado = (char)textoParaCriptografar.charAt(i)  - chaveParaCriptografar;
						char texto = (char) textoCriptografado;
						System.out.print(texto);
					}
				} else {
						int textoCriptografado = (char)textoParaCriptografar.charAt(i);
						char texto = (char) textoCriptografado;
						System.out.print(texto); 
					}
				}
			
			scannerString.close();
			scannerInt.close();
			break;
		}
	}
}
