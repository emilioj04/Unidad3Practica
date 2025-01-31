# -*- coding: utf-8 -*-
from flask import Blueprint, render_template, request
import requests



routes = Blueprint('routes', __name__)

URL = "http://localhost:8080/myapp/"

@routes.route('/', methods=['GET', 'POST'])
def home():
    nodes = []
    edges = []
    camino = []
    peso_total = None

    if request.method == 'POST':
        origen = int(request.form.get('origen'))
        destino = int(request.form.get('destino'))
        algoritmo = request.form.get('algoritmo')

        try:
            r = requests.get("{}graph/minCamino/{}/{}/{}".format(URL, algoritmo, origen, destino))
            print(r.url)
            if r.status_code == 200:
                data = r.json().get('data')
                camino = data if isinstance(data, list) else []
            else:
                print("Error en la respuesta de minCamino: ", r.status_code)

            r = requests.get("{}graph/minPeso/{}/{}/{}".format(URL, algoritmo, origen, destino))
            print(r.url)
            if r.status_code == 200:
                data_peso = r.json().get('data')
                peso_total = data_peso if isinstance(data_peso, (int, float)) else None
            else:
                print("Error en la respuesta de minPeso: ", r.status_code)

        except requests.exceptions.JSONDecodeError:
            print("Error: la respuesta no es un JSON válido.")
        except requests.exceptions.RequestException as e:
            print("Error en la solicitud:", e)

    try:
        r = requests.get(URL + "graph")
        if r.status_code == 200:
            graph_data = r.json().get('data')
            nodes = graph_data.get('nodes', [])
            for node in nodes:
                node['label'] = node.get('nombre', '')
            edges = graph_data.get('edges', [])
        else:
            print("Error en la respuesta del grafo: ", r.status_code)
    except requests.exceptions.JSONDecodeError:
        print("Error: la respuesta del grafo no es un JSON válido.")
    except requests.exceptions.RequestException as e:
        print("Error en la solicitud del grafo:", e)


    return render_template('home.html', nodes=nodes, edges=edges, camino=camino, peso_total=peso_total)