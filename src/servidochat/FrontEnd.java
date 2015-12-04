/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidochat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Antonio
 */
public class FrontEnd extends javax.swing.JFrame {

    private ArrayList<Cliente> clientes = new ArrayList<>();
    private Cliente ultimoCliente;

    /**
     * Creates new form FrontEnd
     */
    public FrontEnd() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bTStart = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        logBook = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        userList = new java.awt.List();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SOSD 2015/2016");
        setResizable(false);

        bTStart.setText("Start");
        bTStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTStartActionPerformed(evt);
            }
        });

        stop.setText("Stop");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        logBook.setColumns(20);
        logBook.setRows(5);
        jScrollPane1.setViewportView(logBook);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Door");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Server Log");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("User List");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bTStart, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stop, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSpinner))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userList, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bTStart)
                            .addComponent(stop)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bTStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTStartActionPerformed

        logBook.append("Server start ... \n");

        Thread();

    }//GEN-LAST:event_bTStartActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        try {
            Thread.sleep(5000);                 //5 segundos.
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        //  enviarMensagemTodos("Server is offline.\n");
        LogBookApend("Server stop.");

        logBook.setText("");
    }//GEN-LAST:event_stopActionPerformed

    private void Thread() {

        Thread t = new Thread(new Runnable() {

            String mensagem;

            @Override
            public void run() {

                try {
                    // int np = Integer.parseInt(portN.toString());
                    // int np = Integer.parseInt(jSpinner.getToolTipText());
                    // logBook.append("Servidor Start at port :" + np + "\n");
                    ServerSocket server = new ServerSocket(12345);
                    Socket socket;

                    while (true) {
                        socket = server.accept();
                        // opção PrintStream - bytes to char
                        PrintWriter writer = new PrintWriter(socket.getOutputStream());
                        Cliente novoCliente = new Cliente(writer);
                        Mensagem msn = new Mensagem(socket, novoCliente);

                    }

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }
        });
        t.start();
    }

    public void LogBookApend(String x) {

        logBook.append(x + "\n");
    }

    public class Mensagem {

        private Socket s;

        public Mensagem(Socket s, Cliente novoCliente) {

            this.s = s;
            ultimoCliente = novoCliente;
            Thread();

        }

        private void Thread() {

            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {

                    String mensagem = "";

                    try {

                        InputStreamReader isr = new InputStreamReader(s.getInputStream());
                        BufferedReader br = new BufferedReader(isr);

                        enviarNomes(mensagem);

                        while ((mensagem = br.readLine()) != null) {
                            LogBookApend(mensagem); // adiciona tudo <<testes>>
                            //remover o nome do utlizador da lista
                            if (mensagem.contains("<offLine>")) {

                                Cliente temp = new Cliente();
                                String userName = mensagem.substring(0, mensagem.length() - 9);
                                temp.setUserName(userName);
                                remover(temp);
                                updateUserList();
                                LogBookApend("Numero de utilizadores : " + clientes.size());
                                LogBookApend(userName + " has just gone.");
                                enviarMensagemTodos(userName + " has just gone.");
                                enviarNomes(mensagem);

                            } else if (mensagem.contains("<onLine>")) {

                                // adicionamos o nome do ultimo user
                                ultimoCliente.setUserName(mensagem.substring(0, mensagem.length() - 8));
                                // adicionamos o user à lista
                                if (!clienteExiste(ultimoCliente)) {
                                    clientes.add(ultimoCliente);
                                } else enviarMensagemClienteNEx(ultimoCliente, "UserInUse");// enviamos todos os userNames
                                {
                                    LogBookApend(ultimoCliente.getUserName() + " has just arrived.");
                                }
                                updateUserList();
                                enviarNomes(mensagem);

                            } else {
                                enviarMensagemTodos(mensagem);
                            }

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });

            t.start();

        }

    }

    public void enviarNomes(String mensagem) {

        for (int i = 0; i < clientes.size(); i++) {

            if (i == 0) {
                mensagem = "<listaClientes>" + clientes.get(i).getUserName();
            } else {
                mensagem += ";" + clientes.get(i).getUserName();
            }
        }

        for (int i = 0; i < clientes.size(); i++) {

            clientes.get(i).getClientCha().println(mensagem);
            clientes.get(i).getClientCha().flush();
        }

    }

    public void enviarMensagemClienteEx(String userName, String mensagem) {

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getUserName().equalsIgnoreCase(userName)) {
                clientes.get(i).getClientCha().println(mensagem);
                clientes.get(i).getClientCha().flush();
            }

        }
    }
    
    
        public void enviarMensagemClienteNEx(Cliente x, String mensagem) {

                x.getClientCha().println(mensagem);
                x.getClientCha().flush();

    }

    public void enviarMensagemTodos(String mensagem) {

        for (int i = 0; i < clientes.size(); i++) {

            clientes.get(i).getClientCha().println(mensagem);
            clientes.get(i).getClientCha().flush();

        }
    }

    private void updateUserList() {

        // limpar a lista de useres 
        userList.removeAll();

        // repovoar a lista de useres 
        for (int i = 0; i < clientes.size(); i++) {
            userList.add(clientes.get(i).getUserName());
        }

    }

    public boolean clienteExiste(Cliente x) {

        for (int i = 0; i < clientes.size(); i++) {

            if (clientes.get(i).getUserName().equalsIgnoreCase(x.getUserName())) {

                return true;
            }

        }

        return false;

    }

    public boolean remover(Cliente x) {

        for (int i = 0; i < clientes.size(); i++) {

            if (clientes.get(i).getUserName().equalsIgnoreCase(x.getUserName())) {
                clientes.remove(i);
                return true;
            }

        }

        return false;

    }

    public static void main(String args[]) {
        /**
         * Criação de um thread para a aplicação e outro para o GUI
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrontEnd().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bTStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner;
    private javax.swing.JTextArea logBook;
    private javax.swing.JButton stop;
    private java.awt.List userList;
    // End of variables declaration//GEN-END:variables

}
