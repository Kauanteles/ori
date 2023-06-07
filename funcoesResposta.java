import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        List<List<String>> conjunto = new ArrayList<List<String>>();
        List<String> consulta = new ArrayList<String>();
        List<String> nomes = new ArrayList<String>();
        nomes.add("a.txt");
        nomes.add("b.txt");
        nomes.add("c.txt");

        consulta.add("casa");
        consulta.add("engracada");

        List<String> a = new ArrayList<String>();
        List<String> b = new ArrayList<String>();
        List<String> c = new ArrayList<String>();

        a.add("era");
        a.add("casa");
        a.add("muito");
        a.add("engracada");
        a.add("tinha");
        a.add("teto");
        a.add("nada");

        b.add("quem");
        b.add("casa");
        b.add("quer");
        b.add("mora");
        b.add("tambem");
        b.add("engracada");

        c.add("quer");
        c.add("casar");
        c.add("comigo");
        c.add("amor");
        c.add("faca");
        c.add("favor");
        c.add("mora");
        c.add("minha");
        c.add("casas");

        conjunto.add(a);
        conjunto.add(b);
        conjunto.add(c);

        preencheArqvResposta(conjunto, consulta, nomes, ';');
    }

    public static File preencheArqvResposta(List<List<String>> conjunto, List<String> consulta, List<String> nomes, Character AndOr) throws IOException {
        if (AndOr == ',') {
            int qntArqvs = 0;
            List<String> nomesArqvs = new ArrayList<String>();

            for (int i = 0; i < conjunto.size(); i++) {
                int indiceConsulta = 0;
                int countArqv = 0;

                for (int j = 0; j < conjunto.get(i).size(); j++) {
                    if (conjunto.get(i).get(j).equals(consulta.get(indiceConsulta))) {
                        countArqv++;
                        indiceConsulta++;
                        j = -1;
                    }
                    if (indiceConsulta >= consulta.size()) {
                        if (countArqv == consulta.size()) {
                            qntArqvs++;
                            nomesArqvs.add(nomes.get(i));
                            break;
                        }
                    }
                }
            }

            File file = new File("resposta.txt");
            FileWriter writer = new FileWriter(file);
            writer.write(qntArqvs + "\n");
            for (int i = 0; i < nomesArqvs.size(); i++) {
                writer.write(nomesArqvs.get(i) + "\n");
            }
            writer.close();

            return file;
        } else {
            int qntArqvs = 0;
            List<String> nomesArqvs = new ArrayList<String>();
            int indiceConsulta = 0;

            for (int i = 0; i < conjunto.size(); i++) {
                for (int j = 0; j < conjunto.get(i).size(); j++) {
                    if (conjunto.get(i).get(j).equals(consulta.get(indiceConsulta))) {
                        qntArqvs++;
                        nomesArqvs.add(nomes.get(i));
                        indiceConsulta = 0;
                        break;
                    }
                    if (j == conjunto.get(i).size() - 1) {
                        indiceConsulta++;
                        j = -1;
                    }
                    if (indiceConsulta >= consulta.size()) {
                        indiceConsulta = 0;
                        break;
                    }
                }
            }

            File file = new File("resposta.txt");
            FileWriter writer = new FileWriter(file);
            writer.write(qntArqvs + "\n");
            for (int i = 0; i < nomesArqvs.size(); i++) {
                writer.write(nomesArqvs.get(i) + "\n");
            }
            writer.close();

            return file;
        }
    }
}
