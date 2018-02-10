/**
 * Linear Probing Hash Table
 */
public class LinearProbingHash<Key, Value> {

  private int N;
  private int M = 16;
  private Key[] keys;
  private Value[] values;

  public LinearProbingHash() {
    keys = (Key[]) new Object[M];
    values = (Value[]) new Object[M];
  }

  public LinearProbingHash(int cap) {
    this.M=cap;
    keys = (Key[]) new Object[M];
    values = (Value[]) new Object[M];
  }

  private int hash(Key key) {
    return (key.hashCode() & 0x7fffffff) % M;
  }

  public Value get(Key key) {
    for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
      if (keys[i].equals(key)) {
        return values[i];
      }
    }
    return null;
  }

  public void put(Key key, Value value) {
    if (N >= M / 2) {
      resize(2 * M);
    }
    int i;
    for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
      if (keys[i].equals(key)) {
        values[i] = value;
        return;
      }
    }
    keys[i] = key;
    values[i] = value;
    N++;
  }

  private void resize(int cap){
    LinearProbingHash<Key,Value> t;
    t=new LinearProbingHash<Key,Value>(cap);
    for(int i=0;i<M;i++){
      if(keys[i]!=null){
        t.put(keys[i],values[i]);
      }
    }
    keys=t.keys;
    values=t.values;
    M=t.M;
  }
}
