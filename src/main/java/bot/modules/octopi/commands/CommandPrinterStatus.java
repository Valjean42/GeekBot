package bot.modules.octopi.commands;

import bot.GeekBot;
import bot.modules.octopi.PrinterEnum;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.util.Map;

public class CommandPrinterStatus extends Command
{
    public CommandPrinterStatus()
    {
        this.hidden = true;
        this.name = "printerStatus";
    }

    @Override
    protected void execute(CommandEvent event)
    {
        final Map<PrinterEnum, String> stateMap = GeekBot.printerStateMonitor.printerState;
        final StringBuilder builder = new StringBuilder();
        builder.append("PrinterStatus for all printers: \n");
        for(PrinterEnum printerEnum : PrinterEnum.values()) {
            builder.append(" [");
            builder.append(printerEnum.ordinal());
            builder.append("] ");
            builder.append(printerEnum.getName());
            builder.append(": ");
            builder.append(stateMap.get(printerEnum));
            builder.append("\n");
        }
        event.getChannel().sendMessage(builder.toString()).submit();
    }
}
