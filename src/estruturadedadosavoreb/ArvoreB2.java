/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavoreb;

import javax.swing.JLabel;

/**
 *
 * @author lucas
 */
class No {

    private int conteudo;
    private No esquerda;
    private No direita;

    public No() {
        esquerda = null;
        direita = null;
    }

    public int getConteudo() {
        return conteudo;
    }

    public void setConteudo(int tconteudo) {
        this.conteudo = tconteudo;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }
}

public class ArvoreB2 extends javax.swing.JFrame {

    /**
     * Creates new form ArvoreB2
     */
    private No raiz;
    private JLabel labels[];
    private String inOrdem;
    private String PreOrdem;
    private String PosOrdem;
    private String Busca;

    public ArvoreB2() {
        initComponents();
        raiz = null;

        labels = new JLabel[19];
        labels[0] = lblA;
        labels[1] = lblB;
        labels[2] = lblC;
        labels[3] = lblD;
        labels[4] = lblF;
        labels[5] = lblE;
        labels[6] = lblG;
        labels[7] = SETAAE;
        labels[8] = SETAAD;
        labels[9] = SETACE;
        labels[10] = SETACD;
        labels[11] = SETABE;
        labels[12] = SETACE;
        labels[13] = SETABD;
        labels[14] = valorBuscado;
        labels[15] = busEsq;
        labels[16] = busDir;
        labels[17] = barraDir;
        labels[18] = barraEsq;

        for (int i = 0; i < 19; i++) {
            labels[i].setVisible(false);
        }

    }

    public boolean vazia() {
        return (raiz == null);
    }

    //Busca recursia
    private No busca(No T, int valor) {

        if (T == null) {
            return null;  // Arvore Vazia
        }
        // Condicao de parada
        if (T.getConteudo() == valor) {
            return T; //Elem. encontrado na raiz
        }

        // Caso recursivo
        No aux = busca(T.getEsquerda(), valor);
        if (aux == null) {
            aux = busca(T.getDireita(), valor);
        }

        return aux;
    }

    //Busca elemento na árvore
    public No busca(int valor) {
        if (vazia()) {
            return null;
        }

        //No res = busca(raiz, valor);
        //return res;
        return busca(raiz, valor);
    }

    //Inserir na raiz 
    public boolean insereRaiz(int valor) {
        if (raiz != null) {
            return false;  //Erro: Arvore não está vazia
        }
        No novoNo = new No();
        novoNo.setConteudo(valor);
        novoNo.setEsquerda(null);
        novoNo.setDireita(null);

        raiz = novoNo;
        return true;
    }

    //Inserir à direira
    public boolean insereDir(int vPai, int vFilho) {

        // Verifica se o elemento já existe
        No filho = busca(vFilho);
        if (filho != null) {
            return false;  // Err: dado já existe
        }
        // Busca o pai e verifica se possui filho direito
        No pai = busca(vPai);
        if (pai == null) {
            return false;  // Err: pai não encontrado
        }
        if (pai.getDireita() != null) {
            return false;  // Err: filho dir já existe
        }
        No novoNo = new No();
        novoNo.setConteudo(vFilho);
        novoNo.setEsquerda(null);
        novoNo.setDireita(null);

        pai.setDireita(novoNo);

        return true;
    }

    //Inserir à esquerda
    public boolean insereEsq(int vPai, int vFilho) {

        // Verifica se o elemento já existe 
        No filho = busca(vFilho);
        if (filho != null) {
            return false;  // Err: dado já existe
        }
        // Busca o pai e verifica se possui filho da esq
        No pai = busca(vPai);
        if (pai == null) {
            return false; // Err: pai não encontrado
        }
        if (pai.getEsquerda() != null) {
            return false; // Err: filho esq já existe
        }
        No novoNo = new No();
        novoNo.setConteudo(vFilho);
        novoNo.setEsquerda(null);
        novoNo.setDireita(null);

        pai.setEsquerda(novoNo);
        return true;
    }

    //Exivir em pré-ordem
    private void exibePreOrdem(No T) {

        PreOrdem += T.getConteudo() + " ";

        // Caminha recursivamente na sub-arv da esq (pre-ordem)
        if (T.getEsquerda() != null) {

            exibePreOrdem(T.getEsquerda());

        }

        // Caminha recursivamente na sub-arv da dir (pre-ordem)
        if (T.getDireita() != null) {

            exibePreOrdem(T.getDireita());
        }

    }

    public String exibePreOrdem() {
        PreOrdem = "";
        if (raiz == null) {
            System.out.println("Arvore vazia");
        } else {
            exibePreOrdem(raiz);
        }
        return PreOrdem;
    }

    //Exibe em in-ordem
    private void exibeInOrdem(No T) {
        if (T == null) {
            return;
        }

        if (T.getEsquerda() != null) {
            exibeInOrdem(T.getEsquerda());
        }

        inOrdem += T.getConteudo() + " ";
        //System.out.print(" " + T.getConteudo());

        if (T.getDireita() != null) {
            exibeInOrdem(T.getDireita());
        }

    }

    public String exibeInOrdem() {
        inOrdem = "";
        if (raiz == null) {
            System.out.println("Arvore vazia");
        } else {
            exibeInOrdem(raiz);

        }
        return inOrdem;
    }

    //Exibe em pos-ordem
    private void exibePosOrdem(No T) {
        if (T == null) {
            return;
        }

        if (T.getEsquerda() != null) {
            exibePosOrdem(T.getEsquerda());
        }

        if (T.getDireita() != null) {
            exibePosOrdem(T.getDireita());
        }

        PosOrdem += T.getConteudo() + " ";
    }

    public String exibePosOrdem() {
        PosOrdem = "";
        if (raiz == null) {
            System.out.println("Arvore vazia");
        } else {
            exibePosOrdem(raiz);
        }
        return PosOrdem;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        lblA = new javax.swing.JLabel();
        SETAAE = new javax.swing.JLabel();
        lblB = new javax.swing.JLabel();
        SETAAD = new javax.swing.JLabel();
        lblC = new javax.swing.JLabel();
        lblD = new javax.swing.JLabel();
        lblF = new javax.swing.JLabel();
        lblG = new javax.swing.JLabel();
        lblE = new javax.swing.JLabel();
        SETACE = new javax.swing.JLabel();
        SETABE = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfValor = new javax.swing.JTextField();
        SETABD = new javax.swing.JLabel();
        SETACD = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        buscar = new javax.swing.JButton();
        PRE = new javax.swing.JLabel();
        valor8 = new javax.swing.JLabel();
        POS = new javax.swing.JLabel();
        IN = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnInserir = new javax.swing.JButton();
        btnExibir = new javax.swing.JButton();
        valorBuscado = new javax.swing.JLabel();
        barraEsq = new javax.swing.JLabel();
        barraDir = new javax.swing.JLabel();
        busDir = new javax.swing.JLabel();
        busEsq = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Árvore Binária");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblA.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblA, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 44, 39));

        SETAAE.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        SETAAE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-para-baixo-à-esquerda-50.png"))); // NOI18N
        getContentPane().add(SETAAE, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        lblB.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 50, 40));

        SETAAD.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        SETAAD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-para-baixo-à-direita-50.png"))); // NOI18N
        getContentPane().add(SETAAD, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        lblC.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblC, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 50, 40));

        lblD.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblD, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 50, 40));

        lblF.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblF, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 50, 40));

        lblG.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblG, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 50, 40));

        lblE.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblE, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 50, 40));

        SETACE.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        SETACE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-abaixo-50.png"))); // NOI18N
        getContentPane().add(SETACE, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));

        SETABE.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        SETABE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-abaixo-50.png"))); // NOI18N
        getContentPane().add(SETABE, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Valor:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        tfValor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(tfValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 92, 28));

        SETABD.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        SETABD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-abaixo-50.png"))); // NOI18N
        getContentPane().add(SETABD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        SETACD.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        SETACD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-abaixo-50.png"))); // NOI18N
        getContentPane().add(SETACD, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, -1));

        jPanel1.setLayout(null);

        buscar.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        jPanel1.add(buscar);
        buscar.setBounds(320, 30, 80, 30);

        PRE.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        PRE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PRE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(PRE);
        PRE.setBounds(430, 140, 153, 36);
        jPanel1.add(valor8);
        valor8.setBounds(370, 170, 0, 0);

        POS.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        POS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        POS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(POS);
        POS.setBounds(430, 280, 153, 36);

        IN.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        IN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(IN);
        IN.setBounds(430, 210, 153, 36);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel3.setText("Pré-Ordem");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(460, 180, 100, 20);

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel8.setText("In-ordem");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(460, 250, 81, 22);

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        jLabel10.setText("Pós-ordem");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(460, 320, 96, 22);

        btnInserir.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        btnInserir.setText("Inserir");
        btnInserir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });
        jPanel1.add(btnInserir);
        btnInserir.setBounds(220, 10, 80, 25);

        btnExibir.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        btnExibir.setText("Exibir");
        btnExibir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExibirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExibir);
        btnExibir.setBounds(220, 50, 80, 25);

        valorBuscado.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        valorBuscado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorBuscado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(valorBuscado);
        valorBuscado.setBounds(470, 10, 30, 30);

        barraEsq.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        barraEsq.setText("/");
        jPanel1.add(barraEsq);
        barraEsq.setBounds(460, 40, 10, 20);

        barraDir.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        barraDir.setText("\\");
            jPanel1.add(barraDir);
            barraDir.setBounds(500, 40, 10, 20);

            busDir.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
            busDir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            busDir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            jPanel1.add(busDir);
            busDir.setBounds(500, 60, 30, 30);

            busEsq.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
            busEsq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            busEsq.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            jPanel1.add(busEsq);
            busEsq.setBounds(440, 60, 30, 30);

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 360));

            jLabel2.setText("jLabel2");
            getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 20, -1));

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        try {
            int valor = Integer.parseInt((tfValor.getText()));

            No novoNo = new No();
            /**
             * *****************
             * A árvore designará os valores a partir de sua raiz, se sua raiz
             * for por ex o valor 50, os valores abaixo de 50 como por exemplo
             * 30, serão adicionados a esquerda da árvore, ao adicionar o valor
             * 30, se vc adicionar um valor maior que 30 e menor que 50, esse
             * valor será adicionado a direita de 30, mas estará a esquerda da
             * raiz, análogo para valores maiores que 50, por ex: 60, esses
             * serão adicionados a direita da raiz, e caso seja adicionado outro
             * valor que seja menor que 60 e maior que 50, por ex: 55 esse valor
             * será adicionado a esquerda de 60 mas estará a direita da raiz que
             * é 50. ***********************************
             */
            if (raiz == null) {
                insereRaiz(valor);
                lblA.setText(Integer.toString(valor));
                raiz.setConteudo(valor);
                lblA.setVisible(true);
            } else if (valor < raiz.getConteudo()) {
                insereEsq(raiz.getConteudo(), valor);
                lblB.setText(Integer.toString(valor));
                lblB.setVisible(true);
                SETAAE.setVisible(true);

                if (valor < raiz.getEsquerda().getConteudo() && raiz.getEsquerda() != null) {
                    //raiz.getEsquerda().setEsquerda(novoNo);
                    int vPai = raiz.getEsquerda().getConteudo();
                    insereEsq(vPai, valor);
                    lblB.setText(Integer.toString(raiz.getEsquerda().getConteudo()));
                    lblD.setText(Integer.toString(valor));
                    lblD.setVisible(true);
                    SETABE.setVisible(true);
                } else if (valor > raiz.getEsquerda().getConteudo()) {
                    //raiz.getEsquerda().setDireita(novoNo);
                    int vPai = raiz.getEsquerda().getConteudo();
                    insereDir(vPai, valor);
                    lblB.setText(Integer.toString(raiz.getEsquerda().getConteudo()));
                    lblE.setText(Integer.toString(valor));
                    lblE.setVisible(true);
                    SETABD.setVisible(true);
                }
            } else if (valor > raiz.getConteudo()) {
                insereDir(raiz.getConteudo(), valor);
                lblC.setText(Integer.toString(valor));
                lblC.setVisible(true);
                SETAAD.setVisible(true);

                if (valor > raiz.getDireita().getConteudo()) {
                    //raiz.getDireita().setDireita(novoNo);
                    int vPai = raiz.getDireita().getConteudo();
                    insereDir(vPai, valor);
                    lblC.setText(Integer.toString(raiz.getDireita().getConteudo()));
                    lblG.setText(Integer.toString(valor));
                    lblG.setVisible(true);
                    SETACD.setVisible(true);
                } else if (valor < raiz.getDireita().getConteudo()) {
                    //raiz.getDireita().setEsquerda(novoNo);
                    int vPai = raiz.getDireita().getConteudo();
                    insereEsq(vPai, valor);
                    lblC.setText(Integer.toString(raiz.getDireita().getConteudo()));
                    lblF.setText(Integer.toString(valor));
                    lblF.setVisible(true);
                    SETACE.setVisible(true);
                }

            } else if (valor > raiz.getEsquerda().getConteudo()) {
                raiz.getEsquerda().setDireita(novoNo);
                insereDir(raiz.getEsquerda().getConteudo(), valor);
                lblE.setText(Integer.toString(valor));
                lblE.setVisible(true);
                SETABD.setVisible(true);

            }
        } catch (Exception e) {
            System.out.println("Digite um valor válido");
        }

    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnExibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExibirActionPerformed
        try {
            PRE.setText(exibePreOrdem());
            System.out.println("\n");
            IN.setText(exibeInOrdem());
            System.out.println("\n");
            POS.setText(exibePosOrdem());
        } catch (Exception e) {
            System.out.println("Digite um valor válido");
        }

    }//GEN-LAST:event_btnExibirActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed

        try {
            valorBuscado.setVisible(true);
            barraDir.setVisible(true);
            barraEsq.setVisible(true);
            busDir.setVisible(true);
            busEsq.setVisible(true);

            int valor = Integer.parseInt(tfValor.getText());

            if (busca(valor).getDireita() == null) {
                valorBuscado.setText(Integer.toString(busca(valor).getConteudo()));
                busDir.setText("Null");
                if (busca(valor).getEsquerda() == null) {
                    busEsq.setText("Null");

                } else {
                    //valorBuscado.setText(Integer.toString(busca(valor).getConteudo()));
                    busEsq.setText(Integer.toString(busca(valor).getEsquerda().getConteudo()));
                }
            } else {
                valorBuscado.setText(Integer.toString(busca(valor).getConteudo()));
                busDir.setText(Integer.toString(busca(valor).getDireita().getConteudo()));
                if (busca(valor).getEsquerda() == null) {
                    busEsq.setText("Null");
                } else {
                    busEsq.setText(Integer.toString(busca(valor).getEsquerda().getConteudo()));
                }
            }
        } catch (Exception e) {
            System.out.println("Digite um valor válido");
        }
        //busDir.setText(Integer.toString(busca(valor).getDireita().getConteudo()));

    }//GEN-LAST:event_buscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ArvoreB2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArvoreB2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArvoreB2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArvoreB2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArvoreB2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IN;
    private javax.swing.JLabel POS;
    private javax.swing.JLabel PRE;
    private javax.swing.JLabel SETAAD;
    private javax.swing.JLabel SETAAE;
    private javax.swing.JLabel SETABD;
    private javax.swing.JLabel SETABE;
    private javax.swing.JLabel SETACD;
    private javax.swing.JLabel SETACE;
    private javax.swing.JLabel barraDir;
    private javax.swing.JLabel barraEsq;
    private javax.swing.JButton btnExibir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JLabel busDir;
    private javax.swing.JLabel busEsq;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblB;
    private javax.swing.JLabel lblC;
    private javax.swing.JLabel lblD;
    private javax.swing.JLabel lblE;
    private javax.swing.JLabel lblF;
    private javax.swing.JLabel lblG;
    private javax.swing.JTextField tfValor;
    private javax.swing.JLabel valor8;
    private javax.swing.JLabel valorBuscado;
    // End of variables declaration//GEN-END:variables
}
