package Methods;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Solution {

    //Поиск символов в файле
    public static void SearchSymbols() throws IOException {
        BufferedReader RD = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(RD.readLine());
        RD.close();
        int c = 0;
        while (input.available() > 0) {
            int b = input.read();
            if (b == 44) {
                c++;
            }
        }
        input.close();
        System.out.println(c);
    }

    //Проверка букв на англиский алфавит
    public static void EnglishAlphabet() throws IOException {
        BufferedReader RD = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(RD.readLine());
        RD.close();
        int a = 0;
        while (input.available() > 0) {

            char c = (char) input.read();

            if (((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z'))) a++;
        }
        System.out.println(a);
    }

    //Проверка символа ввода: буква или число
    public static void Sravnenie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите символ и нажмите enter");
        String str = sc.next();
        char c = str.charAt(0);
        if (Character.isDigit(c)) System.out.println("это цифра");
        if (Character.isLetter(c)) System.out.println("это буква");
        if (".,:;".contains(str)) System.out.println("это пунктуация");
    }

    //Подсчет байтов в файле
    public static void CountByte() throws IOException {
        BufferedReader RD = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(RD.readLine());
        RD.close();
        int a = 0;

        while (input.available() > 0) {
            input.read();
            a++;
        }

        System.out.println(a);
    }

    //Округление до 2 знака
    public static void Okruglenie() {
        int a = 5;
        int b = 5;
        float val = (a * 100 / b);
        String t = String.format("%.2f", val);
    }

    //Добавление одного файла в начало другого
    public static void AddFile() throws IOException {
        BufferedReader RD = new BufferedReader(new InputStreamReader(System.in));
        String r = RD.readLine();//f2 test
        String t = RD.readLine();//f1 test2
        FileInputStream f2 = new FileInputStream(r);
        FileInputStream f11 = new FileInputStream(t);
        RD.close();

        byte[] b = new byte[f2.available()];//test
        byte[] c = new byte[f11.available()];//test2

        while (f2.available() > 0) {//test
            f2.read(b);
        }

        while (f11.available() > 0) {//test2
            f11.read(c);
        }

        FileOutputStream f1 = new FileOutputStream(r);

        f1.write(c);
        f1.write(b);
        f1.close();

        f2.close();

        f11.close();
    }

    //Перезапись файлов с округлением
    public static void OverrideFiles() throws IOException {
        BufferedReader RD = new BufferedReader(new InputStreamReader(System.in));
        String r = RD.readLine();//f2 test
        String t = RD.readLine();//f1 test2
        FileInputStream f2 = new FileInputStream(r);
        FileOutputStream f1 = new FileOutputStream(t);
        RD.close();
        PrintWriter pw = new PrintWriter(t);
        byte[] b = new byte[f2.available()];//test

        while (f2.available() > 0) {//test
            f2.read(b);
        }


        String s = new String(b, "US-ASCII");
        String[] d = s.split(" ");

        for (int i = 0; i < d.length; i++) {
            float a = Float.parseFloat(d[i]);
            int y = Math.round(a);

            pw.println(y);

        }

        f1.close();
        f2.close();
        pw.close();
    }

    //Ввод данных пока не введут число
    public static void EnterData() throws IOException {
        BufferedReader RD = new BufferedReader(new InputStreamReader(System.in));
        String r = null;
        while (true) {
            r = RD.readLine();
            if (r.equals("end")) break;
        }
    }

    //Вывод содержимого файла построчно в консоль
    public static void DataPrint() {
        try {
            FileInputStream fstream = new FileInputStream("K:/test.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                System.out.println(strLine);
            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
    }

    //Поиск нужной строки в файле
    public static void SearchString() throws IOException {
        ArrayList<String> c = new ArrayList<>();

        BufferedReader RD = new BufferedReader(new InputStreamReader(System.in));
        String r = RD.readLine();
        int id = Integer.parseInt(RD.readLine());
        String line;
        FileInputStream f1 = new FileInputStream(r);

        BufferedReader er = new BufferedReader(new InputStreamReader(f1));
        while ((line = er.readLine()) != null) {
            String[] str = line.split(" ");
            if (str[0].contains(String.valueOf(id))) {
                System.out.println(line);
            }
        }
    }

    //Подсчет символов в файле с выводом в консоль
    public static void SymbolCount() throws IOException {
        FileInputStream fs = new FileInputStream("K:/test2.txt");
        Map<Character, Integer> treeMap = new TreeMap<>();
        int[] b = new int[256];
        byte[] c = new byte[fs.available()];
        int t = 0;

        for (int i = 0; i < 256; i++) {
            b[i] = i;
        }

        while (fs.available() > 0) {
            fs.read(c);
        }

        for (int i = 0; i < b.length; i++) {
            t = 0;
            for (int e = 0; e < c.length; e++) {

                if (b[i] == c[e]) {
                    t++;
                    treeMap.put((char) c[e], t);
                }
            }
        }


        for (Map.Entry<Character, Integer> w : treeMap.entrySet()) {
            System.out.println(w.getKey() + " " + w.getValue());

        }
    }

    //Запись в целый файл из нескольких файлов
    public static void MakeOneFile() throws Exception{
        BufferedReader RD = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> map = new TreeSet<>();
        FileOutputStream f1 = new FileOutputStream("K:/test.txt");
        while (true) {
            String f = RD.readLine();
            if (!f.equals("exit")) {
                map.add(f);
            } else break;
        }

        for (String p : map) {
            FileInputStream f2 = new FileInputStream(p);
            byte[] buffer = new byte[f2.available()];
            f2.read(buffer);
            f1.write(buffer);
            f2.close();
        }

        f1.close();
        RD.close();
    }

    //Подсчет слов в файле
    public static void WordsFileCount() throws Exception{
        BufferedReader RD = new BufferedReader(new InputStreamReader(System.in));
        String g = RD.readLine();

        FileReader fr = new FileReader(g);

        String s="";

        while(fr.ready())
        {
            int read = fr.read();
            s =s+ (char)read;}

        String [] str = s.split("\\W");
        int count = 0;

        for(int i=0;i<str.length;++i)
        {
            if(str[i].equals("world"))
            {
                count++;
            }
        }
        System.out.println(count);
        RD.close();

        fr.close();
    }

    //Подсчет символов в файле
    public static void LetterFileCount()throws Exception{
        BufferedReader RD = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader c = new BufferedReader(new FileReader(RD.readLine()));
        BufferedWriter z = new BufferedWriter(new FileWriter(RD.readLine()));
        RD.close();

        String s="";
        String a=null;
        while (c.ready()){
            int data = c.read();
            s =s + (char)data;
            a= s.replace('.','!');
        }
        z.write(a);

        c.close();
        z.close();
    }

     //Удаление всех пунктуационных знаков
    public static void DeletePunctiation() throws  Exception{

        BufferedReader RD = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader c = new BufferedReader(new FileReader(RD.readLine()));
        BufferedWriter z = new BufferedWriter(new FileWriter(RD.readLine()));
        RD.close();

        String s="";
        String a=null;
        while (c.ready()){
            int data = c.read();
            s =s + (char)data;
            a= s.replaceAll("\\p{Punct}", "");
        }
        z.write(a);

        c.close();
        z.close();
    }

    //Проверка файла на числа и их запись в отдельный файл
    public static void CheckNubmer() throws Exception  {

        BufferedReader RD = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader c = new BufferedReader(new FileReader(RD.readLine()));
        BufferedWriter z = new BufferedWriter(new FileWriter(RD.readLine()));
        RD.close();
        ArrayList<Integer> d = new ArrayList<>();
        String s="";
        int t=0;

        while(c.ready())
        {
            int read = c.read();
            s =s+ (char)read;}
        String [] str = s.split(" ");

        for(int i=0;i<str.length;++i)
        { try{t = Integer.parseInt(str[i]);
            d.add(t);}
        catch (NumberFormatException e) {continue;}}

        byte[] buff = new byte[d.size()];
        for (int j = 0; j < d.size(); j++) {

            String x = d.get(j).toString();
            z.write(x + " ");}
        RD.close();
        c.close();
        z.close();
    }

    //Извлечений чисел из строки
    public static void NumberExecution(){
        String result=null;
    StringBuilder stringBuilder = new StringBuilder(result.replaceAll("\\D+",""));

}

    //Поиск чисел в словах
    public static void SearchNumberFile()throws IOException {

        BufferedReader RD = new BufferedReader(new FileReader("K:/test3.txt"));
        BufferedWriter z = new BufferedWriter(new FileWriter("K:/test2.txt"));

        while(RD.ready()){
            String[] s = RD.readLine().split(" ");

            Pattern p = Pattern.compile("\\d");
            for(int i=0; i<s.length; i++){
                Matcher m = p.matcher(s[i]);
                if(m.find()){
                    z.write(s[i] + " ");}}}
        RD.close();
        z.close();}

    //Генератор паролей
    public static void PasswordGen() throws IOException {
        ByteArrayOutputStream bas = new ByteArrayOutputStream(8);
        while(bas.toByteArray().length<8){
            int b = 48 + (int) (Math.random() * ((57 - 48) + 1));
            // System.out.print((char) b);
            bas.write(b);
            int c = 65 + (int) (Math.random() * ((90 - 65) + 1));
            // System.out.print(((char) c));
            bas.write(c);
            int d = 97 + (int) (Math.random() * ((122 - 97) + 1));
            //  System.out.print((char) d);
            bas.write(d);}

        byte a [] = bas.toByteArray();
        for(byte f: a)
            System.out.print((char)f);
    }

    //Замена приписных чисел на обычные
    public static void method() throws IOException{
     /*   public static Map<Integer, String> map = new HashMap<Integer, String>();
        static {map.put(0, "ноль");
            map.put(1, "один");
            map.put(2, "два");
            map.put(3, "три");
            map.put(4, "четыре");
            map.put(5, "пять");
            map.put(6, "шесть");
            map.put(7, "семь");
            map.put(8, "восемь");
            map.put(9, "девять");
            map.put(10, "десять");
            map.put(11, "одиннадцать");
            map.put(12, "двенадцать");}*/

            String e = null;
            String strLine=null;
            BufferedReader RD1 = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader RD = new BufferedReader(new FileReader(RD1.readLine()));
            RD1.close();

            while ((strLine = RD.readLine()) != null) {
                String[] s =strLine.split(" ");

                for (int i = 0; i < s.length; i++) {
                    if (s[i].matches("[0-9]{1,2}")) {
                        for(Map.Entry <Integer, String> map1: map.entrySet())
                            if((Integer.parseInt(s[i]))==map1.getKey())
                                e = map.get(Integer.parseInt(s[i]));
                        s[i] = e;}}
                for(String h: s)
                    System.out.print(h+" ");
                System.out.println(" ");}
            RD.close();}

    //Проход по директориям
    public static void method2() throws IOException {
       /* MyFileVisitor a = new MyFileVisitor(); // объект для обращения к списку TreeSet
        Path path = Paths.get("C:/Users/Николай/IdeaProjects/untitled1");//путь в директорию
        File original = path.resolve("test7.txt").toFile();//имя периименуемого файло
        File newFile = path.resolve("allFilesContent.txt").toFile();//имя переименования

        FileUtils.renameFile(original, newFile); //смена имени файла

        Files.walkFileTree(path, a);//проход по дереву директории

        for (String r : a.A) {//список файлов подходящий под параметры
        Path e = Paths.get(r).toAbsolutePath();//создание пути к файлу из списка
        List<String> l = (Files.readAllLines(e));//содание списка с содержимым файлов
        l.add("");//добавление пустой строки-разделителя

        Files.write(Paths.get( newFile.toString()), l,  StandardOpenOption.APPEND);}//запись файлов

/*class MyFileVisitor extends SimpleFileVisitor<Path> {
    TreeSet<String> A = new TreeSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        if (attrs.size() < 50 && (!(String.valueOf(file.getFileName())).equals("allFilesContent.txt"))) {
            A.add(String.valueOf(file.getFileName()));

        }

        return FileVisitResult.CONTINUE;
    }
}*/

}

    //Поиск файлов в подпапках пути
    public static void method3() throws IOException{
        for(String H: getFileTree("C:/Users/Николай/IdeaProjects/untitled1")){
            System.out.println(H);
        }



  /*  public static List<String> getFileTree(String root) throws IOException {
        List<String> a  = new ArrayList<>();

        Files.walkFileTree(Paths.get(root), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                if (!Files.isDirectory(file)){

                    a.add(file.getFileName().toString());
                }
                return super.visitFile(file, attrs);
            }
        });

        return a;

    }*/

}

    //Подсчет папок в директориях
    public static void method4() throws  IOException{
        System.out.println(getFileTree("C:\\Users\\Николай\\IdeaProjects\\untitled1\\JR").size());
        //}

   /* public static List<String> getFileTree(String root) throws IOException {
        List<String> a  = new ArrayList<>();

        Files.walkFileTree(Paths.get(root), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                if (!Files.isDirectory(file)){

                    a.add(file.getFileName().toString());
                }
                return super.visitFile(file, attrs);
            }
        });

        return a;

    }*/
}

    //Подсчет папок в директориях 2.0
    public static void method5(){
        File dir = new File("C:\\Users\\Николай\\IdeaProjects\\untitled1\\JR");
        String[] files = dir.list();

        for(String s:files){

            if()
                System.out.println(s);
        }
    }

    //Подсчет папок/файлов в директориях
    public static void method6()throws IOException {
        int a=0;
        int b=0;
        File dir = new File("C:\\Users\\Николай\\IdeaProjects\\untitled1\\JR");

        for(File item : dir.listFiles()){

            if(item.isDirectory()){
                a++;
            }

            if(item.isFile()){
                b++;
            }}
        System.out.println(a);
        System.out.println(b);
    }

    //Запись файла в архив
    public static void method7()throws IOException
    {

        String filename = "C:\\Users\\Николай\\IdeaProjects\\untitled1\\JR\\C.txt";
        String filename1 = "C:\\Users\\Николай\\IdeaProjects\\untitled1\\JR\\test2.txt";
        String filename2 = "C:\\Users\\Николай\\IdeaProjects\\untitled1\\JR\\D.txt";

        String ZF = "C:\\Users\\Николай\\IdeaProjects\\untitled1\\JR\\ZIP.zip";
        Path g = Paths.get(filename);
        File[] files = new File[3];
        files[0] = Paths.get(filename).toFile();
        files[1] = Paths.get(filename1).toFile();
        files[2] = Paths.get(filename2).toFile();

        addFilesToExistingZip(Paths.get(ZF).toFile(), files);

   // }

    public static void addFilesToExistingZip(File zipFile, File[] files) throws IOException {
        // get a temp file
        File tempFile = File.createTempFile(zipFile.getName(), null);
        // delete it, otherwise you cannot rename your existing zip to it.
        tempFile.delete();

        boolean renameOk=zipFile.renameTo(tempFile);
        if (!renameOk)
        {
            throw new RuntimeException("could not rename the file "+zipFile.getAbsolutePath()+" to "+tempFile.getAbsolutePath());
        }
        byte[] buf = new byte[1024];

        ZipInputStream zin = new ZipInputStream(new FileInputStream(tempFile));
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFile));

        ZipEntry entry = zin.getNextEntry();
        while (entry != null) {
            String name = entry.getName();
            boolean notInFiles = true;
            for (File f : files) {
                if (f.getName().equals(name)) {
                    notInFiles = false;
                    break;
                }
            }
            if (notInFiles) {
                // Add ZIP entry to output stream.
                out.putNextEntry(new ZipEntry(name));
                // Transfer bytes from the ZIP file to the output file
                int len;
                while ((len = zin.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            }
            entry = zin.getNextEntry();
        }
        // Close the streams
        zin.close();
        // Compress the files
        for (int i = 0; i < files.length; i++) {
            InputStream in = new FileInputStream(files[i]);
            // Add ZIP entry to output stream.
            out.putNextEntry(new ZipEntry(files[i].getName()));
            // Transfer bytes from the file to the ZIP file
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            // Complete the entry
            out.closeEntry();
            in.close();
        }
        // Complete the ZIP file
        out.close();
        tempFile.delete();
    }
}

    //Запись нескольких частей файлов в один
    public static void method8()throws IOException
    {
        ZipInputStream is = new ZipInputStream(new SequenceInputStream(Collections.enumeration(
                Arrays.asList(new FileInputStream("test.zip.001"), new FileInputStream("test.zip.002"), new FileInputStream("test.zip.003")))));
        try {
            for(ZipEntry entry = null; (entry = is.getNextEntry()) != null; ) {
                OutputStream os = new BufferedOutputStream(new FileOutputStream(entry.getName()));
                try {
                    final int bufferSize = 1024;
                    byte[] buffer = new byte[bufferSize];
                    for(int readBytes = -1; (readBytes = is.read(buffer, 0, bufferSize)) > -1; ) {
                        os.write(buffer, 0, readBytes);
                    }
                    os.flush();
                } finally {
                    os.close();
                }
            }
        } finally {
            is.close();
        }
    }
}










