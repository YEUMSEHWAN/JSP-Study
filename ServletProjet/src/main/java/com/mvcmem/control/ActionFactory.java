package com.mvcmem.control;

import com.mvcmem.action.Action;
import com.mvcmem.action.IdCheckAction;
import com.mvcmem.action.IndexAction;
import com.mvcmem.action.LoginFormAction;
import com.mvcmem.action.LoginProcAction;
import com.mvcmem.action.LogoutProcAction;
import com.mvcmem.action.RegFormAction;
import com.mvcmem.action.RegProcAction;
import com.mvcmem.action.ZipCheckAction;
import com.mvcmem.action.deleteFormAction;
import com.mvcmem.action.deleteProcAction;
import com.mvcmem.action.modifyFormAction;
import com.mvcmem.action.modifyProcAction;

public class ActionFactory {

	private static ActionFactory factory;

	private ActionFactory() {
	}

	public static synchronized ActionFactory getInstance() {
		if (factory == null) {
			factory = new ActionFactory();

		}
		return factory;

	}

	public Action getAction(String cmd) { // ServletProject/mvcmem/test.do ?cmd=index
		Action action = null;

		switch (cmd) {

		case "index":
			action = new IndexAction();
			break;

		case "login":
			action = new LoginFormAction();
			break;

		case "loginProc":
			action = new LoginProcAction();
			break;

		case "logout":
			action = new LogoutProcAction();
			break;

		case "regForm":
			action = new RegFormAction();
			break;

		case "regProc":
			action = new RegProcAction();
			break;

		case "idCheck":
			action = new IdCheckAction();
			break;

		case "zipCheck":
			action = new ZipCheckAction();
			break;

		case "modifyForm":
			action = new modifyFormAction();
			break;
			
		case "modifyProc":
			action = new modifyProcAction();
			break;
			
		case "deleteForm":
			action = new deleteFormAction();
			break;
			
		case "deleteProc":
			action = new deleteProcAction();
			break;
			
		default:
			action = new IndexAction();
			break;
		}

		return action;

	}

}
