# -*- coding: utf-8 -*-
import numpy as np
import matplotlib.pyplot as plt 
import pandas as pd

#Importing Dataset

dataset = pd.read_csv('Data.csv')
#Los primeros puntos indica que agarre todos los valores
# Y los otros hasta donde quieres que llegue
X = dataset.iloc[:,:-1].values
y = dataset.iloc[:, 3].values