package ggc.app.main;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.CommandException;
import ggc.core.WarehouseManager;
//FIXME import classes

/**
 * Advance current date.
 */
class DoAdvanceDate extends Command<WarehouseManager> {

  Form form = new Form();

  DoAdvanceDate(WarehouseManager receiver) {
    super(Label.ADVANCE_DATE, receiver);
    //FIXME add command fields
  }

  @Override
  public final void execute() throws CommandException {
    //FIXME implement command
    _receiver.addDate(form.requestInteger(Message.requestDaysToAdvance()));
  }

}
