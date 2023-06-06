import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

class funcoesResposta{

        public static void main(String[] args) {
            List<List<String>> conjunto = new ArrayList<List<String>>();
            List<String> consulta = new ArrayList<String>();
            List<String> nomes = new ArrayList<String>();
            nomes.add(0, "a.txt");
            nomes.add(1, "b.txt");
            nomes.add(2, "c.txt");

            consulta.add(0, "casa");
            consulta.add(1, "engracada");

            List<String> a = new ArrayList<String>();
            List<String> b = new ArrayList<String>();
            List<String> c = new ArrayList<String>();

            a.add(0, "era");
            a.add(1, "casa");
            a.add(2, "muito");
            a.add(3, "engracada");
            a.add(4, "tinha");
            a.add(5, "teto");
            a.add(6, "nada");

            b.add(0, "quem");
            b.add(1, "casa");
            b.add(2, "quer");
            b.add(3, "mora");
            b.add(4, "tambem");
           
            c.add(0, "quer");
            c.add(1, "casar");
            c.add(2, "comigo");
            c.add(3, "amor");
            c.add(4, "faca");
            c.add(5, "favor");
            c.add(6, "mora");
            c.add(7, "minha");
            c.add(8, "casa");

            conjunto.add(0, a);
            conjunto.add(1, b);
            conjunto.add(2, c);

            preencheArqvResposta(conjunto, consulta, nomes);
        }
    
        public static File preencheArqvResposta(List<List<String>> conjunto, List<String> consulta, List<String> nomes){

        if(consulta.contains(",")){ //checa se a consulta é para And

            int qntArqvs = 0;
            List<String> nomesArqvs = new ArrayList<String>();
            int countArqv = 0;

            for(int i = 0; i < conjunto.size(); i++){

                int indiceConsulta = 0;

                for(int j = 0; j < conjunto.get(i).size(); j++){

                    if(conjunto.get(i).get(j) == consulta.get(indiceConsulta)){ //checa se cada palavra da consulta existe no arquivo
                        countArqv++;
                        indiceConsulta++;
                        j = 0;
                    }
                    if(consulta.get(indiceConsulta) == null){ //checa se todas as palavras em consulta existem no arquivo, e salva seu nome e o soma a quantia de arquivo em que a consulta existe
                        if(countArqv == consulta.size()){
                            qntArqvs++;
                            nomesArqvs.add(nomes.get(i)); //n sei como conseguir o nome dos arquivos D:
                            break;
                        }
                    }
                }
            }

            File file = new File( "resposta.txt");

            try {
                FileWriter writer = new FileWriter(file);
                    writer.write(qntArqvs);
                    for(int i =0; i < nomesArqvs.size();i++){
                        writer.write(nomesArqvs.get(i)+"\n");
                    }
                    writer.close();
            } catch (Exception e) {
            }
            return file;

        }else{ //caso a consulta seja para Or

            int qntArqvs = 0;
            List<String> nomesArqvs = new ArrayList<String>();
            int indiceConsulta = 0;

            for(int i = 0; i < conjunto.size(); i++){

                for(int j = 0; j < conjunto.get(i).size(); j++){
                    if(conjunto.get(i).get(j)==consulta.get(indiceConsulta)){ 
                        qntArqvs++;
                        nomesArqvs.add(nomes.get(i)); //n sei como conseguir o nome dos arquivos D:
                        break;
                    }
                    if(j == conjunto.get(i).size()-1){
                        indiceConsulta++;
                        j=0;
                    }
                    if(consulta.get(indiceConsulta)==null){
                        break;
                    }
                }
            }
            File file = new File( "resposta.txt");

            try {
                FileWriter writer = new FileWriter(file);
                    writer.write(qntArqvs);
                    for(int i =0; i < nomesArqvs.size();i++){
                        writer.write(nomesArqvs.get(i)+"\n");
                    }
                writer.close();
            } catch (Exception e) {
            }
            return file;
        }

    }

}