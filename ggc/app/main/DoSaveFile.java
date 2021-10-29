package ggc.app.main;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;
import ggc.app.exception.*;
import ggc.core.exception.*;
import java.io.IOException;
import ggc.core.WarehouseManager;
//FIXME import classes

/**
 * Save current state to file under current name (if unnamed, query for name).
 */
class DoSaveFile extends Command<WarehouseManager> {

  Form _form = new Form();
  String _fileName;

  /** @param receiver */
  DoSaveFile(WarehouseManager receiver) {
    super(Label.SAVE, receiver);
  }

  @Override
  public final void execute() throws CommandException {
    _fileName = _receiver.getFileName();
    if ("".equals(_fileName)) _fileName = _form.requestString(Message.newSaveAs());
    try{
      _receiver.saveAs(_fileName);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
