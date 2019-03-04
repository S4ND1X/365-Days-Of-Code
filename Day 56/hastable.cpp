public class HashEntry {
      private int key;
      private int value;
      HashEntry(int key, int value) {
            this.key = key;
            this.value = value;
      }
      public int getKey() {
            return key;
      }
      public int getValue() {
            return value;
      }
}
public class HashMap {
      private final static int TABLE_SIZE = 128;
      HashEntry[] table;
      HashMap() {
            table = new HashEntry[TABLE_SIZE];
            for (int i = 0; i < TABLE_SIZE; i++)
                  table[i] = null;
      }
public int get(int key) {
    int hash = (key % TABLE_SIZE);
            while (table[hash] != null && table[hash].getKey() != key)

                  hash = (hash + 1) % TABLE_SIZE;
            if (table[hash] == null)
                  return -1;
            else
                  return table[hash].getValue();
      }

 

      public void put(int key, int value) {

            int hash = (key % TABLE_SIZE);

            while (table[hash] != null && table[hash].getKey() != key)

                  hash = (hash + 1) % TABLE_SIZE;

            table[hash] = new HashEntry(key, value);

      }

}

C++ implementation
class HashEntry {

private:

      int key;

      int value;

public:

      HashEntry(int key, int value) {

            this->key = key;

            this->value = value;

      }

 

      int getKey() {

            return key;

      }

 

      int getValue() {

            return value;

      }

};

 

const int TABLE_SIZE = 128;

 

class HashMap {

private:

      HashEntry **table;

public:

      HashMap() {

            table = new HashEntry*[TABLE_SIZE];

            for (int i = 0; i < TABLE_SIZE; i++)

                  table[i] = NULL;

      }

 

      int get(int key) {

            int hash = (key % TABLE_SIZE);

            while (table[hash] != NULL && table[hash]->getKey() != key)

                  hash = (hash + 1) % TABLE_SIZE;

            if (table[hash] == NULL)

                  return -1;

            else

                  return table[hash]->getValue();

      }

 

      void put(int key, int value) {

            int hash = (key % TABLE_SIZE);

            while (table[hash] != NULL && table[hash]->getKey() != key)

                  hash = (hash + 1) % TABLE_SIZE;

            if (table[hash] != NULL)

                  delete table[hash];

            table[hash] = new HashEntry(key, value);

      }

      ~HashMap() {
            for (int i = 0; i < TABLE_SIZE; i++)
                  if (table[i] != NULL)
                        delete table[i];
            delete[] table;
      }
};