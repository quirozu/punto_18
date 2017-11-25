import java.util.Scanner;
 
public class punto_18 {
	
    public static float matriz[][];
    public static int M=4, vs=0;
    public static int X=0, Z=0;
    public static float sumafila=0, sumacolumna=0;
    
    public static void main(String[] args) {
    	System.out.println("Bienvenido al juego");
    	System.out.println(" el juego trata de una matriz 4x4 que debes llenar con valores numericos de tal forma\n que la suma de las filas sea igual a su columna correspondiente sin repetir numero\n");
    
    	mostrar();
    }
    
    public static void mostrar(){
    	Scanner teclado = new Scanner(System.in);
    	int opc;
    	System.out.println(" Una vez iniciado el juego este solo terminara si logras completarlo; ¿DESEAS JUGAR? ");
    	System.out.print(" Digite opción 1: Jugar   2: Salir: ");
    	opc=teclado.nextInt();
    	
    	switch(opc){
    		
    		case 1:
    			Jugar();
    			break;
    		case 2:
    			System.out.print("Has salido del juego, gracias por participar");
    		    break;
    	}
    
    }
    public static void Jugar(){
    	Scanner teclado = new Scanner(System.in);
    	matriz=new float[M][M];
    	
    	float numero, numero2;
    	boolean Q=false, K=false;
    	for(int I=0; I<matriz.length; I++){
    		
    		if(K==false){
    		
    		for(int B=X; B<matriz[I].length; B++){
    			System.out.print("Digite el numero de la fila "+I+" columna "+B+" : ");
    			numero2=teclado.nextFloat();
    			K=Validar(numero2);
    			
    			if(K==false){
    			
    			matriz[I][B]=numero2;
    			}else{
    				
    				while(K==true){
    					System.out.println("El numero esta repetido");
    			System.out.print("Digite el numero de la fila "+I+" columna "+B+" : ");
    				numero2=teclado.nextFloat();
    				K=Validar(numero2);
    				}
    			}
    		matriz[I][B]=numero2;
    		}
    		}
    		while(vs==0){
    		
    		if(Q==false){
    		
    		for(int H=X+1; H<matriz.length; H++){
    			System.out.print("Digite el numero de la fila "+H+" columna "+I+" : ");
    			numero=teclado.nextFloat();
    			Q=Validar(numero);
    			
    			if(Q==false){
    			
    			matriz[H][I]=numero;
    			}else{
    				
    				while(Q==true){
    			System.out.println("El numero esta repetido");
    			System.out.print("Digite el numero de la fila "+H+" columna "+I+" : ");
    				numero=teclado.nextFloat();
    				Q=Validar(numero);
    				}
    			}
    		matriz[H][I]=numero;
    		}
    		validar_sumas();
    		}
    		}
    		
    		X++;
    		vs=0;
    		}
    	System.out.println("FELICITACIONES LO HAS LOGRADO");
    	Imprimir();
    	System.out.println("DESEA VOLVER A JUGAR? ");
    	mostrar();
    }
    
        public static void Imprimir(){
    	
    	for (int J = 0; J < matriz.length; J++ ) {
    		System.out.print("| ");
    		for(int T=0; T<matriz[J].length; T++){
    		
    		System.out.print(matriz[J][T]);
    		if ((J < matriz.length )&& (T<matriz[J].length-1)) {
    			System.out.print(" , ");
    		}
    		
    	}
    	System.out.println(" |");
    }
    }
    public static boolean Validar(float num){
    	int contador=0;
    	for(int P=X; P==X; P++){
    		for(int J=0; J<matriz[P].length; J++){
    			
    			if(num==matriz[P][J]){
    				contador++;
    			}
    		}
    	}
    		for(int P=0; P<matriz.length; P++){
    		for(int J=X; J==X; J++){
    			
    			if(num==matriz[P][J]){
    				contador++;
    			}
    		}
    	}
    	if(contador!=0){
    			contador=0;
    		return true;
    	
    	}
    		contador=0;
    	return false;
    }
    public static void validar_sumas(){
    
    	
    	for(int B=Z; B==Z; B++){
    		for(int L=0; L<matriz[B].length; L++ ){
    			sumafila+=matriz[B][L];
    		}
    		for(int W=0; W<matriz[B].length; W++){
    			sumacolumna+=matriz[W][B];
    		}
    	}
    	if(sumafila==sumacolumna){
    		System.out.println("EXCELENTE LA SUMA DE LA FILA "+X+" Y LA COLUMNA "+X+" SON IGUALES; PUEDES CONTINUAR A LA SIGUIENTE");
    		vs=1;
    		Z++;
    	}else{
    		System.out.println("La suma de la columna no es igual a la de la fila; intenta digitanfo nuevos valores en la columna "+X);
    		vs=0;
    	}
    	System.out.println(" sumas: Fila ="+sumafila+" - columna ="+sumacolumna);
    
    	sumafila=0;
    	sumacolumna=0;
    }
}
