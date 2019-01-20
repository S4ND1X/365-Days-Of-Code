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