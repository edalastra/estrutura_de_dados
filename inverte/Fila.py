class Fila(object):
    def __init__(self):
        self.__dados = []
 
    def insere(self, elemento):
        self.__dados.append(elemento)
 
    def retira(self):
        return self.__dados.pop(0)
 
    def vazia(self):
        return len(self.__dados) == 0

    @property
    def dados(self):
        return self.__dados