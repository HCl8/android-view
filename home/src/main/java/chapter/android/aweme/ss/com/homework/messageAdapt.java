package chapter.android.aweme.ss.com.homework;

import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.R;
import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

/**
 * 适配器
 */
public class messageAdapt extends RecyclerView.Adapter<messageAdapt.NumberViewHolder> {

    private int mNumberItems;

    private List<Message> messageList;
    private Context context;

    private String TAG = "HCl";

    public messageAdapt(List<Message> messages,Context context) {
        messageList = messages;
        mNumberItems = messages.size();
        this.context = context;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);

//        viewHolder.viewHolderIndex.setText("ViewHolder index: " + viewHolderCount);
//
//        int backgroundColorForViewHolder = ColorUtils
//                .getViewHolderBackgroundColorFromInstance(context, viewHolderCount);
//        viewHolder.itemView.setBackgroundColor(backgroundColorForViewHolder);
//
//        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: " + viewHolderCount);
//        viewHolderCount++;
        return new NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder numberViewHolder, int position) {
        Log.d(TAG, "onBindViewHolder: #" + position);
        numberViewHolder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    public class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CircleImageView iv_avatar;
        ImageView robot_notice;
        TextView tv_tittle;
        TextView tv_desc;
        TextView tv_time;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_avatar = itemView.findViewById(R.id.iv_avatar);
            robot_notice = itemView.findViewById(R.id.robot_notice);
            tv_tittle = itemView.findViewById(R.id.tv_title);
            tv_desc = itemView.findViewById(R.id.tv_description);
            tv_time = itemView.findViewById(R.id.tv_time);
            itemView.setOnClickListener(this);
        }

        public void bind(int position) {
            Message message = messageList.get(position);
            if(message.isOfficial())
            robot_notice.setVisibility(View.VISIBLE);
            else
                robot_notice.setVisibility(View.INVISIBLE);
            switch (message.getIcon())
            {
                case "TYPE_GAME":
                    iv_avatar.setImageResource(R.drawable.icon_micro_game_comment);
                    break;
                case "TYPE_ROBOT":
                    iv_avatar.setImageResource(R.drawable.session_robot);
                    break;
                case "TYPE_SYSTEM":
                    iv_avatar.setImageResource(R.drawable.session_system_notice);
                    break;
                case "TYPE_STRANGER":
                    iv_avatar.setImageResource(R.drawable.session_stranger);
                case "TYPE_USER":
                    iv_avatar.setImageResource(R.drawable.icon_girl);
                    break;
            }
            tv_tittle.setText(message.getTitle());
            tv_desc.setText(message.getDescription());
            tv_time.setText(message.getTime());
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            Message message = messageList.get(clickedPosition);
            Intent intent = new Intent(context,ChatRoomActivity.class);
            intent.setAction("我和" + message.getTitle()+"的对话");
            context.startActivity(intent);
        }
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}
