public class Ordenacoes {

    //Função que ordena o vetor pelo método de bubble sort
    public static void bubbleSort(){
        //Definição de variáveis
        int vetor[] = Main.vetorBubbleSort;
        int tamanhoVetor = Main.tamanho;
        int aux = 0;

        //Execução do bubblesort
        for (int i = 0; i < tamanhoVetor; i++){
            //Incrementa a iteração
            Main.iteracoesBS ++;
            for (int j = 1; j < tamanhoVetor; j++){
                //Incrementa a iteração
                Main.iteracoesBS ++;
                if (vetor[j-1] > vetor[j]){
                    //Troca os elementos de posição
                    aux = vetor[j-1];
                    vetor[j-1] = vetor[j];
                    vetor[j] = aux;
                    //Incrementa a troca
                    Main.trocasBS ++;
                }
            }
        }
    }

    //Função que ordena o vetor pelo método de merge sort
    public static void mergeSort(int []vetor, int []auxiliar, int inicio, int fim){
        //Verifica se foi alcaçado o limite de divisão
        if (inicio < fim){
            //Incrementa a iteração
            Main.iteracoesMS ++;
            //Define o meio
            int meio = (int) (inicio + fim) / 2;
            //Chama o merge sort da primeira metade
            mergeSort(vetor, auxiliar, inicio, meio);
            //Chama o merge sort da segunda metade
            mergeSort(vetor, auxiliar, meio+1, fim);
            //Combina as metades
            merge(vetor, auxiliar, inicio, meio, fim);
        }
    }

    //Função que une as metades do vetor
    private static void merge(int []vetor, int []auxiliar, int inicio, int meio, int fim){
        //Popula vetor auxiliar
        for (int i = inicio; i <= fim; i++){
            auxiliar[i] = vetor[i];
        }

        //Indíce da esquerda
        int esquerda = inicio;

        //Indíce da direita
        int direita = meio + 1;

        //Percorre o vetor para comparar e ordenar
        for (int i = inicio; i <= fim; i++){

            //Incrementa a iteração
            Main.iteracoesMS++;

            //Se o meu vetor da esquerda ultrapassar o meio, significa que o mesmo acabou, logo só tem elementos a direita para serem ordenados
            if (esquerda > meio) {
                vetor[i] = auxiliar[direita++];
                //Incrementa a troca
                Main.trocasMS++;
            //Se o meu vetor da direita ultrapassar o fim, significa que o mesmo acabou, logo só tem elementos a esquerda para serem ordenados
            }else if(direita > fim){
                vetor[i] = auxiliar[esquerda++];
                //Incrementa a troca
                Main.trocasMS++;
            //Se o elemeto da esquerda for menor q o da direita, o vetor principal recebe o auxiliar da esquerda
            }else if (auxiliar[esquerda] < auxiliar[direita]){
                vetor[i] = auxiliar[esquerda++];
                //Incrementa a troca
                Main.trocasMS++;
            //Se o elemeto da direita for menor q o da esquerda, o vetor principal recebe o auxiliar da direita
            }else {
                vetor[i] = auxiliar[direita++];
                //Incrementa a troca
                Main.trocasMS++;
            }
        }
    }

    //Função que ordena o vetor pelo método de quick sort
    public static void quickSort(int []vetor, int esquerda, int direita){
        //Enquanto os elementos estiverem desordenados
        if (esquerda < direita){

            //Incrementa a iteração
            Main.iteracoesQS++;

            //Obtém o pivô a partir do método da partição
            int pivo = particao(vetor, esquerda, direita);

            //Ordena a esquerda do pivô
            quickSort(vetor, esquerda, pivo-1);

            //Ordena a direita do pivô
            quickSort(vetor, pivo+1, direita);
        }
    }

    //Método que auxilia na execução do quick sort
    private static int particao(int []vetor, int esquerda, int direita){
        //Definição de variáveis para auxiliar a execução
        int i = esquerda + 1;
        int j = direita;

        //Definição do pivô
        int pivo = vetor[esquerda];

        //Reposicionamento de elementos usando quick sort
        while (i <= j){

            //Incrementa a iteração
            Main.iteracoesQS++;

            //Busca elemento maior que o pivô
            if (vetor[i] <= pivo){
                i++;
            //Busca elemento menor que o pivô
            }else if(vetor[j] > pivo){
                j--;
            //Verifica se o i é menor ou igual ao j
            }else if(i <= j){
                //Realiza a troca de posições
                int aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
                i++;
                j--;
                //Incrementa a troca
                Main.trocasQS++;
            }
        }

        //Realizo a troca do pivô pois o elemento i trocou de posição com o elemento j
        int aux = vetor[esquerda];
        vetor[esquerda] = vetor[j];
        vetor[j] = aux;
        //Incrementa a troca
        Main.trocasQS++;
        return j;
    }


    //Função que imprime o vetor
    public static void  imprimeVetores(){
        //Impressão do vetor principal
        System.out.print("VP:  ");
        for (int i = 0; i < Main.tamanho; i++) {
            //Início do vetor
            if (i == 0) {
                System.out.print("[" + Main.vetorPrincipal[i]);
            //Fim do vetor
            }else if(i == Main.tamanho - 1){
                System.out.println(", " + Main.vetorPrincipal[i] + "]");
            //Decorrer do vetor
            }else{
                System.out.print(", " + Main.vetorPrincipal[i]);
            }
        }

        //Impressão do vetor bubble sort
        System.out.print("VBS: ");
        for (int i = 0; i < Main.tamanho; i++) {
            //Início do vetor
            if (i == 0) {
                System.out.print("[" + Main.vetorBubbleSort[i]);
                //Fim do vetor
            }else if(i == Main.tamanho - 1){
                System.out.println(", " + Main.vetorBubbleSort[i] + "]");
                //Decorrer do vetor
            }else{
                System.out.print(", " + Main.vetorBubbleSort[i]);
            }
        }

        //Impressão do vetor merge sort
        System.out.print("VMS: ");
        for (int i = 0; i < Main.tamanho; i++) {
            //Início do vetor
            if (i == 0) {
                System.out.print("[" + Main.vetorMergeSort[i]);
                //Fim do vetor
            }else if(i == Main.tamanho - 1){
                System.out.println(", " + Main.vetorMergeSort[i] + "]");
                //Decorrer do vetor
            }else{
                System.out.print(", " + Main.vetorMergeSort[i]);
            }
        }

        //Impressão do vetor quick sort
        System.out.print("VQS: ");
        for (int i = 0; i < Main.tamanho; i++) {
            //Início do vetor
            if (i == 0) {
                System.out.print("[" + Main.vetorQuickSort[i]);
                //Fim do vetor
            }else if(i == Main.tamanho - 1){
                System.out.println(", " + Main.vetorQuickSort[i] + "]");
                //Decorrer do vetor
            }else{
                System.out.print(", " + Main.vetorQuickSort[i]);
            }
        }
    }

}
