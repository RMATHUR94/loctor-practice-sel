package dataProviders;

import org.testng.annotations.DataProvider;
import utils.ExcelUtil;

import java.util.List;
import java.util.function.IntFunction;

public class ExcelDataProvider {

    @DataProvider(name = "formdata")
    public Object[][]   formData()
    {
        List<Object[]> data = ExcelUtil.getDataFromExcel("Sheet1");
        return data.toArray(new Object[0][]);
    }
}
