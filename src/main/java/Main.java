import java.util.EnumSet;
import java.util.Iterator;

public class Main {

    enum Lang{
        JAVA,
        PYTHON,
        JS,
        CSHARP
    }

    public static void main(String[] args) {
        String s = "@lfkjsdlf:_?:;";
        String result = s.replaceAll("@:_?:;", "");
        System.out.println(result);


        EnumSet<Lang> allLang = EnumSet.allOf(Lang.class);
        System.out.println(allLang);

        String b = allLang.remove(Lang.JS) ? "delete d" : "not deleted";
        System.out.println(b);
        System.out.println(allLang);

        Iterator<Lang> it = allLang.iterator();
        while (it.hasNext()){
            System.out.println(it.next() + ", ");
        }



    }
}
