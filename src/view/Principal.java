/*
RESUMO      : Classe de execução d o aeroporto
PROGRAMADORA: Luiza Felix
DATA        : 02/04/2023
 */

package view;

import javax.swing.JOptionPane;

import controller.Aviao;

public class Principal {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null,"Todos os avões são designados aleatoriamente para cada pista.\nPara inicializar o aeroporto, clique em 'OK'!");

		for (int i = 1; i <= 12; i++) {
			int pista = (int) (Math.random() * 2 + 1);
			
			Thread aviao = new Aviao(pista, i);
			aviao.start();
		}

	}

}
