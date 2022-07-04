import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void writeFile(String path, ArrayList<String> content){
        try{
            FileWriter filewriter = new FileWriter(path);
            for(int i = 0; i < content.size(); i++){
                String line = content.get(i);
                filewriter.write(line);
                if(i != content.size()-1)
                    filewriter.write("\n");
            }
            filewriter.close();
        }catch (Exception e){
            System.out.println("deu erro aqui. " + e.getMessage());
        }
    }

    public static String readFile(String path){
        try{
            FileReader file = new FileReader(path);
            BufferedReader reader = new BufferedReader(file);
            String line, content = "";
            while((line = reader.readLine()) != null){
                content += line;
                content += '\n';
            }
            return content;
        }catch (Exception e){
            System.out.println("deu erro aqui. " + e.getMessage());
            return "";
        }
    }

    public static void main(String[] args){
        ArrayList<String> arr = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual é o caminho do arquivo?");
        String path = scanner.nextLine();
        if(!(new File(path).exists())){
            System.out.println("Caminho inválido.");
            System.exit(1);
        }
        while(true){
            System.out.print(arr.size() + 1 + "ª linha: ");
            String line = scanner.nextLine();
            if(line.equals("FIM"))
                break;
            arr.add(line);
        }
        writeFile(path, arr);
        System.out.println(readFile(path));
    }
}
