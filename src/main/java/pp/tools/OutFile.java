package pp.tools;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutFile extends DataOutputStream {
	public OutFile(String filename) throws IOException {
		super(new BufferedOutputStream(new FileOutputStream(filename)));
	}

	public OutFile(File file) throws IOException {
		this(file.getPath());
	}
}