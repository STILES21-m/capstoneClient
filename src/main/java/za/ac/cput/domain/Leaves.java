

package za.ac.cput.domain;



/*
LEAVES.java
AUTHOR KULULO MANGCUNYANA
Student Number 219387117
Date 19 Sep 2022
 */

    public class Leaves {
  
        private Long leaveId;
        private Long daysOfLeave;
        protected Leaves() {

        }
        public Leaves(Builder builder)
        {
            this.leaveId=builder.leaveId;
            this.daysOfLeave=builder.daysOfLeave;
        }

        public Long getDaysOfLeave() {

            return daysOfLeave;
        }

        public Long getLeaveId() {

            return leaveId;
        }



        @Override
        public String toString() {
            return "Leave{" +
                    "leaveId=" + leaveId +
                    ", daysOfLeave=" + daysOfLeave +
                    '}';
        }

        public static class Builder
        {
            private Long leaveId;
            private Long daysOfLeave;

            public Builder setLeaveId(Long leaveId) {
                this.leaveId = leaveId;
                return  this;
            }

            public Builder  setDaysOfLeave(Long daysOfLeave) {
                this.daysOfLeave = daysOfLeave;
                return  this;
            }

            public Builder copy(Leaves leave)
            {
                this.leaveId=leave.leaveId;
                this.daysOfLeave=leave.daysOfLeave;


                return this;
            }
            public Leaves build()
            {
                return new Leaves(this);
            }
        }


    }

