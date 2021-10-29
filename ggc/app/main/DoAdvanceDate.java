package ggc.app.main;

import pt.tecnico.uilib.menus.Command;
import ggc.core.exception.InvalidDateValueException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.CommandException;
import ggc.app.exception.InvalidDateException;
import ggc.core.WarehouseManager;
//FIXME import classes

/**
 * Advance current date.
 */
class DoAdvanceDate extends Command<WarehouseManager> {

  DoAdvanceDate(WarehouseManager receiver) {
    super(Label.ADVANCE_DATE, receiver);
    //FIXME add command fields
  }

  @Override
  public final void execute() throws CommandException{
    //FIXME implement command
    int increment = Form.requestInteger(Message.requestDaysToAdvance());
    try{
      _receiver.addDate(increment);
    }catch(InvalidDateValueException e){
      throw new InvalidDateException(e.getIncrement());
    }
  }

}
