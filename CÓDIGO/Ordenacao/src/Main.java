import java.util.Random;
import java.util.Scanner;

public class Main {

    //Criação dos vetores de inteiros
    static int vetorPrincipal[];
    static int vetorBubbleSort[];
    static  int vetorMergeSort[];
    static  int vetorMergeSortAux[];
    static  int vetorQuickSort[];

    //Variáveis de iterações
    static long iteracoesBS = 0;
    static long iteracoesMS = 0;
    static long iteracoesQS = 0;

    //Variáveis de trocas
    static long trocasBS = 0;
    static long trocasMS = 0;
    static long trocasQS = 0;

    //Criação da variável do tamanho do vetor
    static int tamanho = 0;

    public static void main(String[] args) {

        //Criação do gerador
        Random gerador = new Random();

        //Criação do scanner
        Scanner sc = new Scanner(System.in);

        //Variáveis temporais
        long comeco = 0;
        long fim = 0;
        long tempoTotal = 0;

        //Seleção do tamanho do vetor
        int opcaoTamanhoVetor = -1;
        while (opcaoTamanhoVetor != 0){
            System.out.println("1. 50");
            System.out.println("2. 500");
            System.out.println("3. 1.000");
            System.out.println("4. 5.000");
            System.out.println("5. 10.000");
            System.out.println("SELECIONE UM TAMANHO PARA O VETOR: ");
            opcaoTamanhoVetor = sc.nextInt();

            switch (opcaoTamanhoVetor){
                case 1:
                    //Tamanho 50
                    tamanho = 50;
                    opcaoTamanhoVetor = 0;
                    break;
                case 2:
                    //Tamanho 500
                    tamanho = 500;
                    opcaoTamanhoVetor = 0;
                    break;
                case 3:
                    //Tamanho 1000
                    tamanho = 1000;
                    opcaoTamanhoVetor = 0;
                    break;
                case 4:
                    //Tamanho 5000
                    tamanho = 5000;
                    opcaoTamanhoVetor = 0;
                    break;
                case 5:
                    //Tamanho 10000
                    tamanho = 10000;
                    opcaoTamanhoVetor = 0;
                    break;
                default:
                    //Opção inválida
                    System.out.println("Selecione uma opção válida!");
                    break;
            }
        }

        //Define o tamanho dos vetores
        vetorPrincipal = new int[tamanho];
        vetorBubbleSort = new int[tamanho];
        vetorMergeSort = new int[tamanho];
        vetorMergeSortAux = new int[tamanho];
        vetorQuickSort = new int[tamanho];

        //Instancia os vetores
        for (int i = 0; i < tamanho; i++){
            int numero = gerador.nextInt(100000);
            vetorPrincipal[i] = numero;
            vetorBubbleSort[i] = numero;
            vetorMergeSort[i] = numero;
            vetorQuickSort[i] = numero;
        }

        //Menu de Ordenações
        int opcaoOrdenacao = -1;
        while (true){
            System.out.println();
            Ordenacoes.imprimeVetores();
            System.out.println();

            System.out.println("0. Sair");
            System.out.println("1. BubbleSort");
            System.out.println("2. Merge Sort");
            System.out.println("3. Quick Sort");
            System.out.println("SELECIONE UMA OPÇÃO: ");
            opcaoOrdenacao = sc.nextInt();

            switch (opcaoOrdenacao){
                case 0:
                    //Fim do programa
                    System.exit(0);
                    break;
                case 1:
                    //Bubble Sort
                    //Começa a contagem do tempo
                    comeco = System.nanoTime();

                    //Chama a função que ordena o vetor
                    Ordenacoes.bubbleSort();

                    //Finaliza a contagem do tempo
                    fim = System.nanoTime();

                    //Calcula o tempo total da execução
                    tempoTotal = (fim - comeco) / 1000; // Converter para microssegundos

                    //Imprime as informações da execução do bubble sort
                    System.out.println("Ordenação concluída utilizando bubblesort. Iterações totais: " + Main.iteracoesBS + ". Trocas totais: " + Main.trocasBS + ".");
                    System.out.println("Tempo total de execução (bubblesort): " + tempoTotal + " microssegundos.");
                    break;
                case 2:
                    //Merge Sort
                    //Começa a contagem do tempo
                    comeco = System.nanoTime();

                    //Chama a função que ordena o vetor
                    Ordenacoes.mergeSort(vetorMergeSort, vetorMergeSortAux,0, tamanho-1);

                    //Finaliza a contagem do tempo
                    fim = System.nanoTime();

                    //Calcula o tempo total da execução
                    tempoTotal = (fim - comeco) / 1000; // Converter para microssegundos

                    //Imprime as informações da execução do bubble sort
                    System.out.println("Ordenação concluída utilizando merge sort. Iterações totais: " + Main.iteracoesMS + ". Trocas totais: " + Main.trocasMS + ".");
                    System.out.println("Tempo total de execução (merge sort): " + tempoTotal + " microssegundos.");
                    break;
                case 3:
                    //Quick Sort
                    //Começa a contagem do tempo
                    comeco = System.nanoTime();

                    //Chama a função que ordena o vetor
                    Ordenacoes.quickSort(vetorQuickSort, 0, tamanho-1);

                    //Finaliza a contagem do tempo
                    fim = System.nanoTime();

                    //Calcula o tempo total da execução
                    tempoTotal = (fim - comeco) / 1000; // Converter para microssegundos

                    //Imprime as informações da execução do bubble sort
                    System.out.println("Ordenação concluída utilizando quick sort. Iterações totais: " + Main.iteracoesQS + ". Trocas totais: " + Main.trocasQS + ".");
                    System.out.println("Tempo total de execução (quick sort): " + tempoTotal + " microssegundos.");
                    break;
                default:
                    //Opção inválida
                    System.out.println("Selecione uma opção válida!");
                    break;
            }
        }

    }
}
