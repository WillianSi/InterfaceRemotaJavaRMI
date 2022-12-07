package br.edu.ifsuldeminas.mch.sd.rmi.client;

import java.net.MalformedURLException;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import br.edu.ifsuldeminas.mch.sd.rmi.remote.Operations;

public class Client {
	public static void main(String[] args) {
		try {
			Operations calc = (Operations) Naming.lookup("rmi://localhost/CalculatorService");
			System.out.println("Soma: " + calc.sum(100, 5));
			System.out.println("Subitração: " + calc.sub(1040, 5));
			System.out.println("Multiplicação: " + calc.mul(10, 200));
			System.out.println("Divisão: " + calc.div(10.5, 0.1));
			System.out.println("Raiz: " + calc.raiz(12.0, 3.0));
			System.out.println("Potencia: " + calc.pot(4.0, 4.0));
			System.out.println("Porcentagem: " + calc.por(30.0, 200.0));
			System.out.println("Modulo: " + calc.mod(15.0,8.0));
			System.out.println("Fatorial: " + calc.fat(6.0));
			System.out.println("Converção decimal: " + calc.dec(6));
			System.out.println("Converção hexadecimal: " + calc.hex(6));
			
			List<String> lastOperations = calc.lastOperations(2);
			for (String operation : lastOperations)
				System.out.printf("Operação: %s\n", operation);
			
		} catch (MalformedURLException murle) {
			System.out.println("Erro na URL de acesso ao servico.");
		} catch (NotBoundException nbe) {
			System.out.println("Erro ao se ligar ao stub remoto. Nome de servico inválido.");
		}catch (ConnectException re) {
			System.out.println("Erro ao se conectar. Servidor não iniciado.");
		}
		catch (RemoteException re) {
			System.out.println("Erro na chamada remota.");
			re.printStackTrace();
		}
	}
}