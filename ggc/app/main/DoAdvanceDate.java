package ggc.app.main;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.CommandException;
import ggc.app.exception.InvalidDateException;
import ggc.core.WarehouseManager;
//FIXME import classes

/**
 * Advance current date.
 */
class DoAdvanceDate extends Command<WarehouseManager> {

  Form _form = new Form();

  DoAdvanceDate(WarehouseManager receiver) {
    super(Label.ADVANCE_DATE, receiver);
    //FIXME add command fields
  }

  @Override
  public final void execute() throws CommandException{
    //FIXME implement command
    _receiver.addDate(_form.requestInteger(Message.requestDaysToAdvance()));
  }

}
