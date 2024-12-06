import requests

url = 'http://localhost:5000/api'
r = requests.post(url,json={'sl':2, 'sw':2, 'pl':4, 'pw':5})

print(r.json())