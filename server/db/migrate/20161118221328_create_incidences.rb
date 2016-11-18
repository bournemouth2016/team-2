class CreateIncidences < ActiveRecord::Migration[5.0]
  def change
    create_table :incidences do |t|
      t.string :boat
      t.string :coordinates
      t.integer :casualties
      t.string :problem
      t.string :captain

      t.timestamps
    end
  end
end
