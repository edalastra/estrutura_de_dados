from Fila import Fila
from Pilha import Pilha
import time
import os


fila = Fila()
pilha = Pilha()

def cria_fila():

   
    linha = "ADITREVNI "

    for letra in linha:
        fila.insere(letra)
        print('OPERACAO: Adicionar dados na fila')
        imprime_fila()
        time.sleep(1)
        os.system('cls' if os.name == 'nt' else 'clear')

    
    
def passa_dados_para_pilha():
    
    while(len(fila.dados) > 0):
        pilha.empilha(fila.retira())
        print('OPERACAO: Passar dados da fila para pilha')
        time.sleep(1)
        os.system('cls' if os.name == 'nt' else 'clear')
        imprime_fila()
        imprime_pilha()

def passa_dados_para_fila():
    
    while(len(pilha.dados) > 0):
        fila.insere(pilha.desempilha())
        print('OPERACAO: Passar dados da pilha para fila')
        time.sleep(1)
        os.system('cls' if os.name == 'nt' else 'clear')
        imprime_pilha()
        imprime_fila()

def imprime_pilha():
    saida = []
    for i in range(10 - len(pilha.dados)):
        saida.append(' ')
    saida.extend(pilha.dados)
   
    for e in saida:
        print('| {} |'.format(e))
    print()

def imprime_fila():
   
    for i in range(1,11):
        if i > len(fila.dados):
            print('   |', end="")
        else:
            print(' {} |'.format(fila.dados[i - 1]), end="")
    print()

if __name__ == '__main__':
    cria_fila()
    passa_dados_para_pilha()
    passa_dados_para_fila()