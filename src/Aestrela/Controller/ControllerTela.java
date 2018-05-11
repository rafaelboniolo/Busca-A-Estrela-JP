/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aestrela.Controller;


import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JPanel;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;
import Aestrela.View.Tela;
import javax.swing.JOptionPane;

/**
 *
 * @author Alecsander-Note
 */
public class ControllerTela {
    
    private Tela tela;
    private JPanel[][] mapa;
    private int velocidade;
    
    private Tools tool;
    private final Runtime run ;
    
    public ControllerTela(Tela tela){
        this.tela = tela;
        this.mapa = new JPanel[10][10];
        tela.getjPanelMenu2().setBackground(Color.WHITE);
        this.tool = new Tools();
        this.run = Runtime.getRuntime();
    }
    
    public Integer [][] matriz() throws Exception {
        Integer [][] matriz2 = new Integer[10][10];
        
        File arquivo = new File(System.getProperty("java.class.path")
                        +tool.barra()+"python-graph-master"+tool.barra()+"core"+tool.barra()+"matrizNUm.txt");
        FileReader arquivoLeitura = new FileReader(arquivo);
        BufferedReader leitor = new BufferedReader(arquivoLeitura);
        int k =0;
        String teste = leitor.readLine();
        String [] vet = teste.split(" ");
            for(int i = 0; i < 10;i++){
                for(int j = 0; j<10;j++){
                    matriz2[i][j] = Integer.valueOf(vet[k]);
                    k++;
                }
            }
		return matriz2;
    }
    public void rodarAestrela(){
         
        try{
            run.exec(tool.python()+" "+System.getProperty("java.class.path")
                    +tool.barra()+"python-graph-master"+tool.barra()+"core"+tool.barra()+"Automato.py");
        }catch(IOException e){
            printStackTrace(e);
        }
         
    }
    public void iniciarBusca() throws FileNotFoundException, IOException, InterruptedException{
        File arquivo = new File(System.getProperty("java.class.path")
                        +tool.barra()+"python-graph-master"+tool.barra()+"core"+tool.barra()+"caminhoBusca.txt");
        FileReader arquivoLeitura = new FileReader(arquivo);
        BufferedReader leitor = new BufferedReader(arquivoLeitura);
        int k =0;
        String teste = leitor.readLine();
        if(teste.equals("false")){
            JOptionPane.showMessageDialog(null, "Caminho impossivel");
            resetarMapa();
        }else{
            
            String [] vet = teste.split(" ");

            for (String vet1 : vet) {
                String[] aux = vet1.split("x");
                
                this.mapa[Integer.valueOf(aux[0])][Integer.valueOf(aux[1])].setBackground(Color.BLUE);
            }
            tela.getjButtonIniciar().setEnabled(false);
            tela.getjButton1().setEnabled(true);
            tela.getjButtonGerar().setEnabled(!true);
        }
        
        
    }
    public void gerarMapa(Integer [][] matriz){
        
        tela.getjButtonIniciar().setEnabled(true);
        tela.getjButton1().setEnabled(true);
        tela.getjButtonGerar().setEnabled(!true);
        this.definirMatriz();
        tela.getjLabelFraseStatus().setText("Gerando Mapa");
        
        
        for(int i=0; i<10; i++){
            
            for(int j=0; j<10; j++){
                
                switch (matriz[i][j]) {
                    case 1:
                        mapa[i][j].setBackground(Color.WHITE);
                        break;
                    case 10:
                        mapa[i][j].setBackground(Color.GRAY);
                        break;
                    case 4:
                        mapa[i][j].setBackground(Color.YELLOW);
                        break;
                    case 20:
                        mapa[i][j].setBackground(Color.GREEN);
                        break;
                    default:
                        mapa[i][j].setBackground(Color.BLACK);
                        break;
                }
                
                if(i==0 && j==0){
                    mapa[i][j].setBackground(Color.BLUE);
                }
                if(i==9 && j==9){
                    mapa[i][j].setBackground(Color.MAGENTA);
                }     
                
            }
        }
        tela.getjLabelFraseStatus().setText("Pronto para iniciar!");
    }
    
    public void defineDestino(String destino) throws IOException{
        
        try (FileWriter arquivo = new FileWriter(System.getProperty("java.class.path")
                +tool.barra()+"python-graph-master"+tool.barra()+"core"+tool.barra()+"destino.txt")) {
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
            gravarArquivo.printf(destino);
            arquivo.close();
        }
        
    }
    
    public void resetarMapa(){
        tela.getjButton1().setEnabled(!true);
        tela.getjButtonIniciar().setEnabled(!true);
        tela.getjButtonGerar().setEnabled(true);
        for(int i = 0; i<10;i++){
            for(int j=0;j<10;j++){
                mapa[i][j].setBackground(Color.LIGHT_GRAY);
            }
        }
        tela.getjLabelFraseStatus().setText("Deve gerar mapa");
        
    }
    
    public void definirMatriz(){
        
        mapa[0][0] = tela.getjPanel1();
        mapa[0][1] = tela.getjPanel2();
        mapa[0][2] = tela.getjPanel3();
        mapa[0][3] = tela.getjPanel4();
        mapa[0][4] = tela.getjPanel5();
        mapa[0][5] = tela.getjPanel6();
        mapa[0][6] = tela.getjPanel7();
        mapa[0][7] = tela.getjPanel8();
        mapa[0][8] = tela.getjPanel9();
        mapa[0][9] = tela.getjPanel10();
        
        mapa[1][0] = tela.getjPanel11();
        mapa[1][1] = tela.getjPanel12();
        mapa[1][2] = tela.getjPanel13();
        mapa[1][3] = tela.getjPanel14();
        mapa[1][4] = tela.getjPanel15();
        mapa[1][5] = tela.getjPanel16();
        mapa[1][6] = tela.getjPanel17();
        mapa[1][7] = tela.getjPanel18();
        mapa[1][8] = tela.getjPanel19();
        mapa[1][9] = tela.getjPanel20();
        
        mapa[2][0] = tela.getjPanel21();
        mapa[2][1] = tela.getjPanel22();
        mapa[2][2] = tela.getjPanel23();
        mapa[2][3] = tela.getjPanel24();
        mapa[2][4] = tela.getjPanel25();
        mapa[2][5] = tela.getjPanel26();
        mapa[2][6] = tela.getjPanel27();
        mapa[2][7] = tela.getjPanel28();
        mapa[2][8] = tela.getjPanel146();
        mapa[2][9] = tela.getjPanel30();
        
        mapa[3][0] = tela.getjPanel31();
        mapa[3][1] = tela.getjPanel32();
        mapa[3][2] = tela.getjPanel33();
        mapa[3][3] = tela.getjPanel34();
        mapa[3][4] = tela.getjPanel35();
        mapa[3][5] = tela.getjPanel36();
        mapa[3][6] = tela.getjPanel37();
        mapa[3][7] = tela.getjPanel38();
        mapa[3][8] = tela.getjPanel39();
        mapa[3][9] = tela.getjPanel40();
        
        mapa[4][0] = tela.getjPanel41();
        mapa[4][1] = tela.getjPanel42();
        mapa[4][2] = tela.getjPanel43();
        mapa[4][3] = tela.getjPanel44();
        mapa[4][4] = tela.getjPanel45();
        mapa[4][5] = tela.getjPanel46();
        mapa[4][6] = tela.getjPanel47();
        mapa[4][7] = tela.getjPanel48();
        mapa[4][8] = tela.getjPanel49();
        mapa[4][9] = tela.getjPanel50();
        
        mapa[5][0] = tela.getjPanel51();
        mapa[5][1] = tela.getjPanel52();
        mapa[5][2] = tela.getjPanel53();
        mapa[5][3] = tela.getjPanel54();
        mapa[5][4] = tela.getjPanel55();
        mapa[5][5] = tela.getjPanel56();
        mapa[5][6] = tela.getjPanel57();
        mapa[5][7] = tela.getjPanel58();
        mapa[5][8] = tela.getjPanel59();
        mapa[5][9] = tela.getjPanel60();
        
        mapa[6][0] = tela.getjPanel61();
        mapa[6][1] = tela.getjPanel62();
        mapa[6][2] = tela.getjPanel63();
        mapa[6][3] = tela.getjPanel64();
        mapa[6][4] = tela.getjPanel65();
        mapa[6][5] = tela.getjPanel66();
        mapa[6][6] = tela.getjPanel67();
        mapa[6][7] = tela.getjPanel68();
        mapa[6][8] = tela.getjPanel69();
        mapa[6][9] = tela.getjPanel70();
        
        mapa[7][0] = tela.getjPanel71();
        mapa[7][1] = tela.getjPanel72();
        mapa[7][2] = tela.getjPanel73();
        mapa[7][3] = tela.getjPanel74();
        mapa[7][4] = tela.getjPanel75();
        mapa[7][5] = tela.getjPanel76();
        mapa[7][6] = tela.getjPanel77();
        mapa[7][7] = tela.getjPanel78();
        mapa[7][8] = tela.getjPanel79();
        mapa[7][9] = tela.getjPanel80();
        
        mapa[8][0] = tela.getjPanel81();
        mapa[8][1] = tela.getjPanel82();
        mapa[8][2] = tela.getjPanel83();
        mapa[8][3] = tela.getjPanel84();
        mapa[8][4] = tela.getjPanel85();
        mapa[8][5] = tela.getjPanel86();
        mapa[8][6] = tela.getjPanel87();
        mapa[8][7] = tela.getjPanel88();
        mapa[8][8] = tela.getjPanel89();
        mapa[8][9] = tela.getjPanel90();
        
        mapa[9][0] = tela.getjPanel91();
        mapa[9][1] = tela.getjPanel92();
        mapa[9][2] = tela.getjPanel93();
        mapa[9][3] = tela.getjPanel94();
        mapa[9][4] = tela.getjPanel95();
        mapa[9][5] = tela.getjPanel96();
        mapa[9][6] = tela.getjPanel97();
        mapa[9][7] = tela.getjPanel98();
        mapa[9][8] = tela.getjPanel99();
        mapa[9][9] = tela.getjPanel100();
        
    }
    
}
