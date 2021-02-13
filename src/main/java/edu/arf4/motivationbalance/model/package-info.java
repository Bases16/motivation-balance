@org.hibernate.annotations.GenericGenerator(
        name = "MY_ID_GENERATOR",
        strategy = "enhanced-sequence",
        parameters = {
                @org.hibernate.annotations.Parameter(
                        name = "sequence_name",
                        value = "mot_bal_sequence"
                ),
                @org.hibernate.annotations.Parameter(
                        name = "initial_value",
                        value = "1000"
                )
        })
package edu.arf4.motivationbalance.model;
