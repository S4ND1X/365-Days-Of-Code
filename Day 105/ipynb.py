#!/usr/bin/env python
# coding: utf-8

import matplotlib.pyplot as plt
%matplotlib inline
import random
import numpy as np
import pandas as pd
from sklearn import datasets, svm, tree, preprocessing, metrics
import sklearn.ensemble as ske
from sklearn import model_selection as ms
import tensorflow as tf
import tensorflow.contrib.learn as skflow


# In[10]:


#Leer el excel
titanic_df = pd.read_excel('titanic3.xls', 'titanic3', index_col=None, na_values=['NA'])


# In[11]:


titanic_df.head()


# In[12]:


titanic_df['survived'].mean()


# In[13]:


titanic_df.groupby('pclass').mean()


# In[14]:


#Agrupar por clase y genero
class_sex_grouping = titanic_df.groupby(['pclass','sex']).mean()
class_sex_grouping


# In[15]:


#Grafica de sobrevivientes segun genero y clase
class_sex_grouping['survived'].plot.bar()


# In[16]:


#Agrupar por edades, de 0 a  90 y de 10 en 10
group_by_age = pd.cut(titanic_df["age"], np.arange(0, 90, 10))
age_grouping = titanic_df.groupby(group_by_age).mean()

#% de sobrevivientes segun edad
age_grouping['survived'].plot.bar()


# In[17]:


titanic_df.count()
#Numero de datos por columna


# In[18]:


titanic_df = titanic_df.drop(['body','cabin','boat'], axis=1)
#Remover la columa de cabina, bote y body


# In[19]:


titanic_df["home.dest"] = titanic_df["home.dest"].fillna("NA")
#Columa de destino se reemplaza por "NA"


# In[20]:


titanic_df = titanic_df.dropna()


# In[21]:


titanic_df.count()
#Mismo numero de valores en todas las columnas 


# In[22]:



def preprocess_titanic_df(df):
    """ Elimina el nombre, ticket y destinacion. Y convierte el genero en 0 y 1"""
    processed_df = df.copy()
    le = preprocessing.LabelEncoder()
    processed_df.sex = le.fit_transform(processed_df.sex)
    processed_df.embarked = le.fit_transform(processed_df.embarked)
    processed_df = processed_df.drop(['name','ticket','home.dest'],axis=1)
    return processed_df


# In[23]:


processed_df = preprocess_titanic_df(titanic_df)


# In[24]:


#X Contiene todos los valores de las filas menos survived
X = processed_df.drop(['survived'], axis=1).values
#y Contiene unicamente los datos de la columa 'Survived'
y = processed_df['survived'].values


# In[25]:


# Separa el data set en un 80% para entrenar y un 20% para testear
X_train, X_test, y_train, y_test = ms.train_test_split(X,y,test_size=0.2)


# In[26]:


clf_dt = tree.DecisionTreeClassifier(max_depth=10)


# In[27]:


#Analiza las diferencias entre nuestro modelo y los test
clf_dt.fit (X_train, y_train)
clf_dt.score (X_test, y_test)


# In[28]:


#Crea 20 variaciones diferentes 80-20 y saca la desviacion estandar y promedio de todas
shuffle_validator = ms.ShuffleSplit( n_splits=20, test_size=0.2, random_state=0)
def test_classifier(clf):
    scores = ms.cross_val_score(clf, X, y, cv=shuffle_validator)
    print("Accuracy: %0.4f (+/- %0.2f)" % (scores.mean(), scores.std()))


# In[29]:


#Predice con un 77% de certeza.
test_classifier(clf_dt)


# In[30]:


clf_rf = ske.RandomForestClassifier(n_estimators=50)
test_classifier(clf_rf)
""" Algoritmo de Random Forest, sobre todo para prevenir el Overfitting"""


# In[31]:


clf_gb = ske.GradientBoostingClassifier(n_estimators=50)
test_classifier(clf_gb)

""" Crea varios arboles y los combina en una, no es optimo"""


# In[32]:


eclf = ske.VotingClassifier([('dt', clf_dt), ('rf', clf_rf), ('gb', clf_gb)])
test_classifier(eclf)
""" Este sera el ultimo en decidir en caso de que los otros dos  no tengan el mismo resultado."""


# In[37]:


tf_clf_dnn = skflow.DNNClassifier(hidden_units=[20, 40, 20], n_classes=2, batch_size=256, steps=1000, learning_rate=0.05)
tf_clf_dnn.fit(X_train, y_train)
tf_clf_dnn.score(X_test, y_test)


# In[34]:


def custom_model(X, y):
    layers = skflow.ops.dnn(X, [20, 40, 20], tf.tanh)
    return skflow.models.logistic_regression(layers, y)


# In[36]:


tf_clf_c = skflow.Estimator(model_fn=custom_model, n_classes=2, batch_size=256, steps=1000, learning_rate=0.05)
tf_clf_c.fit(X_train, y_train)
metrics.accuracy_score(y_test, tf_clf_c.predict(X_test))


# In[38]:



passengers_set_1 = titanic_df[titanic_df.pclass == 1].iloc[:20,:].copy()
passengers_set_2 = titanic_df[titanic_df.pclass == 2].iloc[:20,:].copy()
passengers_set_3 = titanic_df[titanic_df.pclass == 3].iloc[:20,:].copy()
passenger_set = pd.concat([passengers_set_1,passengers_set_2,passengers_set_3])
testing_set = preprocess_titanic_df(passenger_set)


# In[39]:


training_set = pd.concat([titanic_df, passenger_set]).drop_duplicates(keep=False)
training_set = preprocess_titanic_df(training_set)


# In[40]:


X_train = training_set.drop(['survived'], axis=1).values
y_train = training_set['survived'].values
X_test = testing_set.drop(['survived'], axis=1).values
y_test = testing_set['survived'].values


# In[41]:


tf_clf_dnn.fit (X_train, y_train)
tf_clf_dnn.score (X_test, y_test)


# In[42]:


prediction = tf_clf_dnn.predict(X_test)
passenger_set[passenger_set.survived != prediction]


# In[ ]:




