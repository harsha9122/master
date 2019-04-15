import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;

public class IntWritable3Values implements Writable {
  public int x;
  public int y;
  public int z;

  public IntWritable3Values(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public IntWritable3Values() {
    this(0, 0, 0);
  }

  public void write(DataOutput out) throws IOException {
    out.writeInt(x);
    out.writeInt(y);
    out.writeInt(z);
  }

  public void readFields(DataInput in) throws IOException {
    x = in.readInt();
    y = in.readInt();
    z = in.readInt();
  }

  public String toString() { 
    return Integer.toString(x) + ", "
        + Integer.toString(y) + ", "
        + Integer.toString(z);
  }
}
