from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score
from sklearn import tree
import pandas as pd

csv_url = 'https://docs.google.com/spreadsheets/d/1bR7kx1gL3EansCPAsADkbRsqRmLPmJ-q7U4aZO0yl18/export?format=csv&id=1bR7kx1gL3EansCPAsADkbRsqRmLPmJ-q7U4aZO0yl18'
df = pd.read_csv(csv_url)
print(df)

variedade_replace = {'Setosa': 0, 'Versicolor': 1, 'Virginica':2}
df['Variedade_Cod'] = df['especie'].replace(variedade_replace)
iris_list = ['Setosa', 'Versicolor', 'Virginica']
print(iris_list[0])
print(df)

X = df.drop(columns=['especie', 'Variedade_Cod'])
y =  df['Variedade_Cod']
print(X)
print(y)

#split de dados
X_train, X_test, y_train, y_test = train_test_split(X.values, y.values, test_size=0.3, random_state=50)
print(X_train.shape)
#print(X_test)
print(len(y_train))
print(len(y_test))

# Classifier
clf = tree.DecisionTreeClassifier()
clf = clf.fit(X_train, y_train)

y_pred = clf.predict(X_test)

accuracy = accuracy_score(y_test, y_pred)
print("Acurácia do modelo:", accuracy)

import pickle
pickle.dump(clf, open('model.pkl','wb')) # salvando o modelo
pickle.dump(iris_list,open('names.pkl','wb')) # salvando os identificadores de saida