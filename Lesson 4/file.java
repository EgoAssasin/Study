package Lesson_4;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Egor on 23.12.2017.
 */

public class file {
    public static void main(String args[]){
        String str="";
        int i=0;
        ArrayList<String> mlist = new ArrayList<>();//Для хранения слов использую массив ArrayList
        //String stroka="test";

        /**
         *Для чтения из файла использую метод BufferedReader в кодировке cp1251
         */
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Egor\\IdeaProjects\\helloWorld\\Study\\Lesson 4\\Задание.txt"),"cp1251")))
        {
            /**
             * Отбрасываю служебные символы,цифры. Беру только слова.
             */
            while (i !=-1){
                i = br.read();
                if ((((char) i)!=' ')&&(((char) i)!=',')&&(((char) i)!='.')&&(((char) i)!=':')&&(((char) i)!=';')&&(((char) i)!='!')&&(((char) i)!='?')&&(((char) i)!='`')&&
                        (((char) i)!='\"')&&(((char) i)!='\'')&&(((char) i)!='%')&&(((char) i)!='#')&&(((char) i)!='№')&&(((char) i)!='*')&&(((char) i)!='*')&&(((char) i)!='-')&&
                        (((char) i)!='+')&&(((char) i)!='=')&&(((char) i)!='_')&&(((char) i)!='{')&&(((char) i)!='}')&&(((char) i)!='[')&&(((char) i)!=']')&&(((char) i)!='|')&&
                        (((char) i)!='1')&&(((char) i)!='2')&&(((char) i)!='3')&&(((char) i)!='4')&&(((char) i)!='5')&&(((char) i)!='6')&&(((char) i)!='7')&&(((char) i)!='8')&&(((char) i)!='9')
                        &&(i!=13)&&(i!=10))
                {
                    str=str+Character.toString((char)i);
                }
                else{
                    if ((!str.equals(" "))&&(!str.equals(","))&&(!str.equals("."))&&(!str.equals(":"))&&(!str.equals(";"))&&(!str.equals("!"))&&(!str.equals("?"))&&(!str.equals("`"))&&
                            (!str.equals("\""))&&(!str.equals("\""))&&(!str.equals("%"))&&(!str.equals("#"))&&(!str.equals("№"))&&(!str.equals("*"))&&(!str.equals("*"))&&(!str.equals("-"))&&
                            (!str.equals("+"))&&(!str.equals("="))&&(!str.equals("_"))&&(!str.equals("{"))&&(!str.equals("}"))&&(!str.equals("["))&&(!str.equals("]"))&&(!str.equals("|"))&&
                            (!str.equals("1"))&&(!str.equals("2"))&&(!str.equals("3"))&&(!str.equals("4"))&&(!str.equals("5"))&&(!str.equals("6"))&&(!str.equals("7"))&&(!str.equals("8"))&&(!str.equals("9"))
                            &&(!str.equals("\r"))
                            &&(!str.equals("\n"))
                            &&(!str.equals(""))
                            )
                    {mlist.add(str);}
                    str="";
                }

            }
            System.out.print("---------Вывод всех слов в тексте-------------\n"+mlist+"\n");
            Collections.sort(mlist); //Сортировка в прямом порядке
            //Collections.sort(mlist,Collections.reverseOrder()); //Сортировка в обратном порядке
            System.out.print("---------Отсортированный вывод всех слов в тексте-------------\n"+mlist+"\n");
            /**
             * Для подсчёта количества слов использую новую коллекцию на основе Map. Ключ - слова в файле, значение - количество слов в файле
             */
            Map<String, Integer> statistics = new HashMap<>();
            for (int k=0;k<mlist.size();k++) {
                Integer count = statistics.get(mlist.get(k));
                if (count==null){
                    count=0;
                }
                statistics.put(mlist.get(k),++count);
            }
            System.out.print("---------Каждое слово встречается в файле----------\n"+statistics+"\n");
            int max=0;
            String maxSlovo="";
            for (String key: statistics.keySet()) {
                int value = statistics.get(key);
                if (max<value){
                    max=value;
                    maxSlovo=key;
                }
            }
            System.out.print("------------Итого-----------\nCлово с максимальным количеством повторений: \"" + maxSlovo +"\"\nВстречается в файле: " + max + " раз\n");
            //System.out.println(statistics.keySet());
        }
        catch (FileNotFoundException e){System.out.println("Ошибка ввода-вывода: " + e);}
        catch (UnsupportedEncodingException e){System.out.println("Ошибка ввода-вывода: " + e);}
        catch (IOException e){System.out.println("Ошибка ввода-вывода: " + e);}




        /*// Для записи в файл использую FileOutputStream(path,true) данный метод в кодировке cp1251
        try {
            BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\Egor\\IdeaProjects\\helloWorld\\Study\\Lesson 4\\Задание.txt",true),"cp1251"));
            br.write(stroka);
            br.newLine();
            br.close();
        }
        catch (FileNotFoundException e){System.out.println("Ошибка ввода-вывода: " + e);}
        catch (UnsupportedEncodingException e){System.out.println("Ошибка ввода-вывода: " + e);}
        catch (IOException e){System.out.println("Ошибка ввода-вывода: " + e);}*/
    }
}
