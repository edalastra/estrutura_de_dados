class Pilha(object):
    def __init__(self):
        self.__dados = []
 
    def empilha(self, elemento):
        self.__dados.insert(0,elemento)
 
    def desempilha(self):
        if not self.vazia():
            return self.__dados.pop(0)
 
    def vazia(self):
        return len(self.__dados) == 0

    @property
    def dados(self):
        return self.__dados
        