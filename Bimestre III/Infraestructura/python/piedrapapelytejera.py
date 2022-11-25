import random
import sys

puntajeUsuario = 0
puntajePc = 0
puntajeTotal = 0

def porcentaje():
        puntajeTotal=puntajeUsuario+puntajePc
        if puntajeTotal!=0:
            porcentaje_victorias=puntajeUsuario/puntajeTotal*100
            return porcentaje_victorias
        else:
            return 0;

def get_int():
    userdata = input("Ingrese un número, o 's' para salir del programa ")
    if userdata == 's':
        print ("Nos vemos!")
        sys.exit()
    try:
        user_num = int(userdata)
        return user_num
    except ValueError:
        print("Necesito un número para continuar: ")
        return(get_int())

while True: 
    aleatorio = random.randrange(0, 5)
    elijePc = ""
    again = ""
    print("1)Piedra")
    print("2)Papel")
    print("3)Tijera")
    print("4)Lagarto")
    print("5)Spock")
    print("6)Mostrar Puntajes")
    opcion = get_int()
    
    if opcion == 1:
        eligeUsuario = "piedra"
    elif opcion == 2:
        eligeUsuario = "papel"
    elif opcion == 3:
        eligeUsuario = "tijera"
    elif opcion == 4:
        eligeUsuario = "lagarto"
    elif opcion == 5:
        eligeUsuario = "spock"
    elif opcion == 6:
        print ("Puntajes: ")
        print ("Usuario: ", puntajeUsuario)
        print ("Pc: ", puntajePc)
        print ("Porcentaje de victorias: ", porcentaje(), "%")
        continue
    else:
        print("Opción Invalida")
        continue

    print("Tu eliges: ", eligeUsuario)    
    if aleatorio == 0:
        eligePc = "piedra"
    elif aleatorio == 1:
        eligePc = "papel"
    elif aleatorio == 2:
        eligePc = "tijera"
    elif aleatorio == 3:
        eligePc = "lagarto"
    elif aleatorio == 4:
        eligePc = "spock"
    print("PC eligio: ", eligePc)
    print("...")
    
    if eligePc == "piedra" and eligeUsuario == "papel":
        print("Ganaste, papel envuelve piedra")
        puntajeUsuario=puntajeUsuario+1
    elif eligePc == "papel" and eligeUsuario == "tijera":
        print("Ganaste, tijera corta papel")
        puntajeUsuario=puntajeUsuario+1
    elif eligePc == "tijera" and eligeUsuario == "piedra":
        print("Ganaste, piedra aplasta tijera")
        puntajeUsuario=puntajeUsuario+1
    elif eligePc == "lagarto" and eligeUsuario == "piedra":
        print("Ganaste, piedra aplasta a lagarto")
        puntajeUsuario=puntajeUsuario+1
    elif eligePc == "lagarto" and eligeUsuario == "tijera":
        print("Ganaste, tijera decapita a Lagarto")
        puntajeUsuario=puntajeUsuario+1
    elif eligePc == "tijera" and eligeUsuario == "spock":
        print("Ganaste, Spock rompe tijera")
    elif eligePc == "spock" and eligeUsuario == "lagarto":
        print("Ganaste, lagarto envenena a Spock")
        puntajeUsuario=puntajeUsuario+1
    elif eligePc == "papel" and eligeUsuario == "lagarto":
        print ("Ganaste, lagarto devora papel")
        puntajeUsuario=puntajeUsuario+1
    elif eligePc == "spock" and eligeUsuario == "papel":
        print ("Ganaste, papel desautoriza a Spock")
        puntajeUsuario=puntajeUsuario+1
    elif eligePc == "piedra" and eligeUsuario == "spock":
        print ("Ganaste, Spock vaporiza piedra")
        puntajeUsuario=puntajeUsuario+1

    if eligeUsuario == "piedra" and eligePc == "papel":
        print("Perdiste, papel envuelve piedra")
        puntajePc=puntajePc+1
    elif eligeUsuario == "papel" and eligePc == "tijera":
        print("Perdiste, tijera corta papel")
        puntajePc=puntajePc+1
    elif eligeUsuario == "tijera" and eligePc == "piedra":
        print("Perdiste, piedra aplasta tijera")
        puntajePc=puntajePc+1
    elif eligeUsuario == "lagarto" and eligePc == "piedra":
        print("Perdiste, piedra aplasta a lagarto")
        puntajePc=puntajePc+1
    elif eligeUsuario == "lagarto" and eligePc == "tijera":
        print("Perdiste, tijera decapita a Lagarto")
        puntajePc=puntajePc+1
    elif eligeUsuario == "tijera" and eligePc == "spock":
        print("Perdiste, Spock rompe tijera")
        puntajePc=puntajePc+1
    elif eligeUsuario == "spock" and eligePc == "lagarto":
        print("Perdiste, lagarto envenena a Spock")
        puntajePc=puntajePc+1
    elif eligeUsuario == "papel" and eligePc == "lagarto":
        print ("Perdiste, lagarto devora papel")
        puntajePc=puntajePc+1
    elif eligeUsuario == "spock" and eligePc == "papel":
        print ("Perdiste, papel desautoriza a Spock")
        puntajePc=puntajePc+1
    elif eligeUsuario == "piedra" and eligePc == "spock":
        print ("Perdiste, Spock vaporiza piedra")
        puntajePc=puntajePc+1
    elif eligePc == eligeUsuario:
        print("Empate")
    
    while again == "":
        again = input("Jugamos de nuevo? Si/No: ")
        if 'si' in again:
            break
        elif 'no' in again:
            print("Nos vemos!")
            sys.exit()
        else:
            print("Valor Invalido")
            again = ""
            continue

        #Pregunta 1

        #La division por cero: si se deja en una sola condición 
        #no se cumple ninguna de la opciones ya que no es posible 
        #realizar una división por cero. 

        #Pregunta 2

        # La persistencia es la acción de conservar la 
        # información de un objeto de forma permanente,
        # pero también de recuperarla. Para esto existe 
        # algo conocido como serialización de objetos. 
        # La serialización de un objeto consiste en generar 
        # una secuencia de bytes para su almacenamiento. 
        # Después, mediante la deserialización, el estado 
        # original del objeto se puede reconstruir. 
        # A la hora de realizar trabajos en los que sea necesario 
        # almacenar la información y recuperarla para su posterior 
        # uso, es muy útil utilizar algunas de las siguientes librerías: 
        # Pickle y Shelve. Esto es posible hacerlo en Python con las librerías 
        # Pickle y CPyckle. La diferencia entre estas dos librerías 
        # es sencillamente que la segunda está escrita en C.