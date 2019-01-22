# -*- coding: utf-8 -*-
import numpy as np
import matplotlib.pyplot as plt 
import pandas as pd

#Importing Dataset

dataset = pd.read_csv('Data.csv')

X = dataset.iloc[:,:-1].values
y = dataset.iloc[:, 3].values

#How to fill empty data
from sklearn.preprocessing import Imputer
#First parameter is of what to take care of, second one is how and 3 is where
imputer = Imputer(missing_values = 'NaN', strategy = 'mean', axis = 0)
imputer = imputer.fit(X[:, 1:3])
X[:, 1:3] = imputer.transform(X[:, 1:3])

# Encoding Categorical Data
from sklearn.preprocessing import LabelEncoder, OneHotEncoder
#Nombramos una variable con ese metodo
labelencoder_X = LabelEncoder()
#Ponemos de donde queremos que nos encode los datos
X[:, 0] = labelencoder_X.fit_transform(X[:, 0])
#Se usa para pasar los datos a tres columnas y que no haya mas grandes
onehotencoder = OneHotEncoder(categorical_features = [0])
X = onehotencoder.fit_transform(X).toarray()
labelencoder_y = LabelEncoder()
y= labelencoder_Y.fit_transform(y)



 