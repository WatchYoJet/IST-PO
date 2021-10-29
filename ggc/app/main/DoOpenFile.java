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
 * Open existing saved state.
 */
class DoOpenFile extends Command<WarehouseManager> {
  String _fileName;

  /** @param receiver */
  DoOpenFile(WarehouseManager receiver) {
    super(Label.OPEN, receiver);
    //FIXME maybe add command fields
  }

  @Override
  public final void execute() throws CommandException {
    _fileName = Form.requestString(Message.openFile());
    try {
      _receiver.load(_fileName);
    } catch (Exception e){
      throw new FileOpenFailedException(_fileName);
    }
  }

}
