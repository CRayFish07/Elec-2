package junit;

import org.junit.Test;

import com.yzx.elec.container.ServiceProvider;
import com.yzx.elec.service.IElecRoleService;
import com.yzx.elec.service.IElecSystemDDlService;


public class TestElecSystemDDL {

	//@Test
	public void testServiceFindKeyWord() {
		Object obj = ServiceProvider.getService(IElecSystemDDlService.SERVICE_NAME);
		IElecSystemDDlService service = (IElecSystemDDlService)obj;
		service.findKeyWord();
	}
	
	@Test
	public void testUserRoleServiceFindUserList() {
		IElecRoleService service = (IElecRoleService)ServiceProvider.getService(IElecRoleService.SERVICE_NAME);
		service.findElecUserListByRoleId("0");
	}

}
