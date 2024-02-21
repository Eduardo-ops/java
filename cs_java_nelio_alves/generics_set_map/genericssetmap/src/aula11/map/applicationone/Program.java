package aula11.map.applicationone;

import java.util.Map;
import java.util.TreeMap;

public class Program {

    public static void main(String[] args) {

        /*
         * Estrutura em map para armazenagem de cookies
         * TreeMap faz ordenação pela chave
         * */
        Map<String, String> cookies = new TreeMap<>();

        /*
         * Operação que permite adicionar conteúdo em um map
         * */
        cookies.put("user name", "Maria");
        cookies.put("email", "maria.goncalves@hotmail.com");
        cookies.put("phone", "991234567");

        /*
         * Operação que permite remover conteúdo em um map
         * */
        cookies.remove("email");

        /*
         * Se adicionarmos novamente um elemento com a mesma chave,
         * a última inserção sobrepoe ao antecessor
         * */
        cookies.put("phone", "97654321");

        /*
         * Verificando se uma determinada key existe
         * */
        if (cookies.containsKey("phone")) {
            System.out.println("Yeah, exists key in cookies!");
        }

        /*
         * Pegando a informação que contém na key de phone
         *  */
        System.out.println("Phone number: " + cookies.get("phone"));

        /*
         * Operação que permite saber o tamanho total do armazenamento
         * */
        System.out.println("Size: " + cookies.size());

        System.out.println("All Cookies");
        for (String key : cookies.keySet()) {
            System.out.println(key + ":" + cookies.get(key));
        }
    }
}
