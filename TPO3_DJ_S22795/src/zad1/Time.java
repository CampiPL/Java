/**
 * @author Depka Jakub S22795
 */

package zad1;

import java.text.DecimalFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Time {

    public static String passed(String from, String to) {

        DecimalFormat df = new DecimalFormat("0.00");
        String s = "";
        boolean bool = false;

        for (char c : from.toCharArray())
            if (c == 'T') {
                bool = true;
                break;
            }

        if (bool) {

            LocalDateTime f;
            LocalDateTime t;
            String patt = "d MMMM yyyy (EEEE) 'godz.' HH:mm";

            try {
                f = LocalDateTime.parse(from);
                t = LocalDateTime.parse(to);
            } catch (DateTimeParseException e) {
                return "*** " + e;
            }

            ZonedDateTime zdtf = ZonedDateTime.of(f, ZoneId.of("Europe/Warsaw"));
            ZonedDateTime zdtt = ZonedDateTime.of(t, ZoneId.of("Europe/Warsaw"));

            s += "Od " + f.format(DateTimeFormatter.ofPattern(patt, new Locale("pl"))) + " do " +
                    t.format(DateTimeFormatter.ofPattern(patt, new Locale("pl")));

            s += "\n - mija: " + ChronoUnit.DAYS.between(zdtf, zdtt);
            if (ChronoUnit.DAYS.between(zdtf, zdtt) == 1)
                s += " dzień";
            else
                s += " dni";

            s += ", tygodni " + df.format(Double.parseDouble(String.valueOf(ChronoUnit.DAYS.between(zdtf, zdtt))
            ) / 7).replace(",", ".");

            s += "\n - godzin: " + ChronoUnit.HOURS.between(zdtf, zdtt) + ", minut: " + ChronoUnit.MINUTES.between
                    (zdtf, zdtt);

            if (ChronoUnit.DAYS.between(zdtf, zdtt) >= 1) {
                s += "\n - kalendarzowo:";

                if (Period.between(LocalDate.parse(from.split("T")[0]), LocalDate.parse(to.split("T")[0]))
                        .getYears() >= 1) {

                    s += " " + Period.between(LocalDate.parse(from.split("T")[0]), LocalDate.parse(to.split
                            ("T")[0])).getYears();

                    if (Period.between(LocalDate.parse(from.split("T")[0]), LocalDate.parse(to.split("T")[0])
                    ).getYears() == 1)
                        s += " rok";
                    else if (Period.between(LocalDate.parse(from.split("T")[0]), LocalDate.parse(to.split
                            ("T")[0])).getYears() > 1 && Period.between(LocalDate.parse(from.split("T")[0]),
                            LocalDate.parse(to.split("T")[0])).getYears() < 5)
                        s += " lata";
                    else
                        s += " lat";
                }

                if (Period.between(LocalDate.parse(from.split("T")[0]), LocalDate.parse(to.split("T")[0]))
                        .getMonths() >= 1) {

                    s += " " + Period.between(LocalDate.parse(from.split("T")[0]), LocalDate.parse(to.split
                            ("T")[0])).getMonths();

                    if (Period.between(LocalDate.parse(from.split("T")[0]), LocalDate.parse(to.split("T")[0])
                    ).getMonths() == 1)
                        s += " miesiąc";
                    else if (Period.between(LocalDate.parse(from.split("T")[0]), LocalDate.parse(to.split("T")[0])
                    ).getMonths() > 1 && Period.between(LocalDate.parse(from.split("T")[0]), LocalDate.parse(to.
                            split("T")[0])).getMonths() < 5)
                        s += " miesiące";
                    else
                        s += " miesięcy";
                }
                if (Period.between(LocalDate.parse(from.split("T")[0]), LocalDate.parse(to.split("T")[0])
                ).getDays() >= 1) {

                    s += " " + Period.between(LocalDate.parse(from.split("T")[0]), LocalDate.parse(to.split
                            ("T")[0])).getDays();

                    if (Period.between(LocalDate.parse(from.split("T")[0]), LocalDate.parse(to.split("T")[0])
                    ).getDays() == 1)
                        s += " dzień";
                    else
                        s += " dni";
                }

            }
        } else {

            LocalDate f;
            LocalDate t;
            String patt = "d MMMM yyyy (EEEE)";

            try {
                f = LocalDate.parse(from);
                t = LocalDate.parse(to);
            } catch (DateTimeParseException e) {
                return "*** " + e;
            }

            s += "Od " + f.format(DateTimeFormatter.ofPattern(patt, new Locale("pl"))) + " do " +
                    t.format(DateTimeFormatter.ofPattern(patt, new Locale("pl")));

            s += "\n - mija: " + ChronoUnit.DAYS.between(f, t);
            if (ChronoUnit.DAYS.between(f, t) == 1)
                s += " dzień";
            else
                s += " dni";
            s += ", tygodni " + df.format(Double.parseDouble(String.valueOf(ChronoUnit.DAYS.between(f, t))) / 7)
                    .replace(",", ".");

            if (ChronoUnit.DAYS.between(f, t) >= 1) {
                s += "\n - kalendarzowo:";

                if (Period.between(LocalDate.parse(from), LocalDate.parse(to)).getYears() >= 1) {

                    s += " " + Period.between(LocalDate.parse(from), LocalDate.parse(to)).getYears();

                    if (Period.between(LocalDate.parse(from), LocalDate.parse(to)).getYears() == 1)
                        s += " rok";
                    else if (Period.between(LocalDate.parse(from), LocalDate.parse(to)).getYears() > 1 && Period.
                            between(LocalDate.parse(from), LocalDate.parse(to)).getYears() < 5)
                        s += " lata";
                    else
                        s += " lat";
                }

                if (Period.between(LocalDate.parse(from), LocalDate.parse(to)).getMonths() >= 1) {

                    if (Period.between(LocalDate.parse(from), LocalDate.parse(to)).getYears() >= 1)
                        s += ",";

                    s += " " + Period.between(LocalDate.parse(from), LocalDate.parse(to)).getMonths();

                    if (Period.between(LocalDate.parse(from), LocalDate.parse(to)).getMonths() == 1)
                        s += " miesiąc";
                    else if (Period.between(LocalDate.parse(from), LocalDate.parse(to)).getMonths() > 1 && Period.
                            between(LocalDate.parse(from), LocalDate.parse(to)).getMonths() < 5)
                        s += " miesiące";
                    else
                        s += " miesięcy";
                }
                if (Period.between(LocalDate.parse(from), LocalDate.parse(to)).getDays() >= 1) {

                    if (Period.between(LocalDate.parse(from), LocalDate.parse(to)).getYears() >= 1 ||
                            Period.between(LocalDate.parse(from), LocalDate.parse(to)).getMonths() >= 1)
                        s += ",";

                    s += " " + Period.between(LocalDate.parse(from), LocalDate.parse(to)).getDays();

                    if (Period.between(LocalDate.parse(from), LocalDate.parse(to)).getDays() == 1)
                        s += " dzień";
                    else
                        s += " dni";
                }

            }
        }

        return s;
    }
}
