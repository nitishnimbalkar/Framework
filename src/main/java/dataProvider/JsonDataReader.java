package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import managers.FileReaderManager;
import testDataTypes.Customer;

public class JsonDataReader {
	private String customerFilePath;
	private ConfigFileReader configReader;
	private List<Customer> customerData;

	public JsonDataReader() {
		configReader = FileReaderManager.getInstance().getConfigReader();
		customerFilePath = configReader.getTestDataResourcePath() + "Customer.json";
		customerData = getCustomerData();
	}

	private List<Customer> getCustomerData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(customerFilePath));
			Customer[] customers = gson.fromJson(bufferReader, Customer[].class);
			return Arrays.asList(customers);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + customerFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	public final Customer getCustomerByName(String customerName) {
		return customerData.stream().filter(x -> x.firstName.equalsIgnoreCase(customerName)).findAny().get();
	}
}
