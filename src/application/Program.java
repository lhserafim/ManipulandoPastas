package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o caminho da pasta: ");
        String strPath = sc.next();
        // caminho recebendo o caminho da pasta
        File path = new File(strPath);

        System.out.println("getName: " + path.getName());
        System.out.println("getParent: " + path.getParent());
        System.out.println("getPath: " + path.getPath());

        try {
            // carregar o vetor com todos os diretórios do caminho
            File[] folders = path.listFiles(File::isDirectory); // dentro da função temos o filtro
            //File[] folders = path.listFiles(); // sem filtro
            System.out.println("PASTAS");
            for (File c : folders) {
                System.out.println(c);
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e) {
            e.printStackTrace();
        }
        try {
            // carregar o vetor com todos os diretórios do caminho
            File[] files = path.listFiles(File::isFile); // dentro da função temos o filtro
            System.out.println("FILES");
            for (File c : files) {
                System.out.println(c);
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e) {
            e.printStackTrace();
        }

        // Criando um diretório
        boolean status = new File(strPath + "/teste").mkdir();
        System.out.println(status);

        sc.close();
    }


}
