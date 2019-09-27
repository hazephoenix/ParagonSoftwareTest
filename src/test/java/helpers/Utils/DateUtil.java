package helpers.Utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

        public class DateUtil {

            public static void main(String[] args) {
                String s = todayDateTime().trim();
                System.out.println(s);
            }
        /**
         * Возвращает текущую дату в формате "дд.мм.гггг"
         *
         * @return строковое представление даты в нужном формате
         */
        public static String todayDate() {
            return LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.uuuu"));
        }

        /**
         * Возвращает текущую дату и время в формате "дд.мм.гггг чч:мм:сс"
         *
         * @return строковое представление даты и времени в нужном формате
         */
        public static String todayDateTime() {
            return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.uuuu_HH.mm.ss"));
        }

    }


