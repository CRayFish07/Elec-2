package junit;

import org.junit.Test;

import com.yzx.elec.container.ServiceProvider;
import com.yzx.elec.service.IElecSystemDDlService;
import com.yzx.elec.service.impl.ElecSystemDDLServiceImpl;


public class TestElecSystemDDL {

	@Test
	public void testServiceFindKeyWord() {
		Object obj = ServiceProvider.getService(IElecSystemDDlService.SERVICE_NAME);
		IElecSystemDDlService service = (IElecSystemDDlService)obj;
		service.findKeyWord();
	}

}
